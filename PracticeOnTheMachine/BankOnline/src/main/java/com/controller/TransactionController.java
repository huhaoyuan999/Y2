package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.Account;
import com.pojo.Transaction;
import com.service.AccountService;
import com.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 交易记录表控制类
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {
    //调用交易记录表业务逻辑接口
    @Autowired
    @Qualifier("transactionService")
    private TransactionService transactionService;

    //调用账户信息表业务逻辑类接口
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    /**
     * 跳转到转账操作功能
     *
     * @return
     */
    @RequestMapping("/Transfer")
    public String pageTransfer(Model model) {
        model.addAttribute("welcome", "OK");
        model.addAttribute("Transfer", "OK");
        return "record";
    }

    /**
     * 查询交易记录
     *
     * @param model
     * @return
     */
    @RequestMapping("/recording")
    public String pageRecording(Model model) {
        model.addAttribute("welcome", "OK");
        model.addAttribute("recording", "OK");
        return "record";
    }

    /**
     * 修改密码
     *
     * @param model
     * @return
     */
    @RequestMapping("/password")
    public String pageUpdatePassword(Model model) {
        model.addAttribute("welcome", "OK");
        model.addAttribute("password", "OK");
        return "record";
    }

    /**
     * 转账操作
     *
     * @return
     */
    @Transactional
    @RequestMapping(value = "/submitTransfer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String submitAccount(@RequestBody Account account) {
        String info = null;
        //查询是否有此卡号
        int num1 = accountService.queryCardNoInfo(account.getAccountNumber());
        //判断是否是正常账户
        int num2 = accountService.queryCardNoPasswordStatus(account.getAccountNumber(), "123456", 1);
        //根据卡号获取转出账户余额
        Account accountBalance = accountService.queryCardNoAccountInfo(account.getCardNo());
        //根据卡号获取目标账户余额
        Account accountBalance2 = accountService.queryCardNoAccountInfo(account.getAccountNumber());

        if (num1 <= 0) {
            return info = "转账失败！目标账户不存在！";
        } else if (num2 <= 0) {
            return info = "转账失败！目标账户已冻结！";
        } else if (accountBalance.getBalance() < account.getBalance()) {
            return info = "转账失败，转出账户余额不足";
        } else {
            //账户转入
            int judgment1 = accountService.UpdateInputEnter(account.getAccountNumber(), account.getBalance());
            //账户转出
            int judgment2 = accountService.UpdateInputOut(account.getCardNo(), account.getBalance());
            //封装取款信息
            Transaction transaction1 = new Transaction();
            transaction1.setCardNo(account.getCardNo());
            transaction1.setTransactionDate(new Date());
            transaction1.setTransactionAmount(account.getBalance());
            transaction1.setBalance(accountBalance.getBalance());
            transaction1.setTransactionType("取款");
            //添加取款记录
            int judgment3 = transactionService.insertTransactionInfo(transaction1);

            //封装存款信息
            Transaction transaction2 = new Transaction();
            transaction2.setCardNo(account.getAccountNumber());
            transaction2.setTransactionDate(new Date());
            transaction2.setTransactionAmount(account.getBalance());
            transaction2.setBalance(accountBalance2.getBalance());
            transaction2.setTransactionType("存款");
            //添加存款记录
            int judgment4 = transactionService.insertTransactionInfo(transaction2);

            //判断交易是否成功
            if (judgment1 > 0 && judgment2 > 0 && judgment3 > 0 && judgment4 > 0) {
                info = "true";
            }
        }
        return info;
    }

    /**
     * 根据时间范围查询交易记录
     */
    @RequestMapping("/page/{before}/{after}")
    public String queryTransactionInfo(@PathVariable("before") String before,
                                       @PathVariable("after") String after,
                                       Model model) {
        if (before == null || before.equals("")) {
            before = "2000-01-01";
        }
        if (after == null || after.equals("")) {
            after = "2020-01-01";
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = df.parse(before);//将string转换成固定日期格式
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date2 = null;
        try {
            date2 = df.parse(after);//将string转换成固定日期格式
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PageInfo<Transaction> pageInfo = transactionService.queryTransactionInfo(date1, date2, 1, 6);
        model.addAttribute("before", before);
        model.addAttribute("after", after);
        model.addAttribute("welcome", "HIDE");
        model.addAttribute("recording2", "OK");
        model.addAttribute("page", pageInfo);
        return "record";
    }

    /**
     * 分页显示查询信息
     *
     * @return
     */
    @RequestMapping("/pages/{pageNo}/{pageSize}/{before}/{after}")
    public String pageShowInfo(@PathVariable("pageNo") Integer pageNo,
                               @PathVariable("pageSize") Integer pageSize,
                               @PathVariable("before") String before,
                               @PathVariable("after") String after,
                               Model model) {
        if (before == null || before.equals("")) {
            before = "2000-01-01";
        }
        if (after == null || after.equals("")) {
            after = "2020-01-01";
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //将string转换成固定日期格式
        Date date1 = null;
        try {
            date1 = df.parse(before);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //将string转换成固定日期格式
        Date date2 = null;
        try {
            date2 = df.parse(after);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PageInfo<Transaction> pageInfo = transactionService.queryTransactionInfo(date1, date2, pageNo, pageSize);
        model.addAttribute("before", before);
        model.addAttribute("after", after);

        model.addAttribute("welcome", "hide");
        model.addAttribute("recording2", "show");
        model.addAttribute("page", pageInfo);
        return "record";
    }
}
