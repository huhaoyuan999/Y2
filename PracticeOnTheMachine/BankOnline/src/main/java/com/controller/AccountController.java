package com.controller;

import com.pojo.Account;
import com.service.AccountService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 账户信息表控制类
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    //调用账户信息表业务逻辑类接口
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    /**
     * 用户登入
     *
     * @param account
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String loginInfo(@RequestBody Account account, HttpSession session) {
        String info = null;
        //查询是否有此卡号
        int num1 = accountService.queryCardNoInfo(account.getCardNo());
        //判断卡号跟密码是否正确
        int num2 = accountService.queryCardNoPassword(account.getCardNo(), account.getPassword());
        //判断是否是正常账户
        int num3 = accountService.queryCardNoPasswordStatus(account.getCardNo(), account.getPassword(), account.getStatus());

        if (num1 <= 0) {
            return info = "登入失败！您输入的卡号不存在！";
        } else if (num2 <= 0) {
            return info = "登入失败！密码错误！";
        } else if (num3 <= 0) {
            return info = "登入失败！账户已冻结！";
        } else {
            info = "true";
            session.setAttribute("cardNo", account.getCardNo());
        }
        return info;
    }

    /**
     * 设置Session失效
     *
     * @param session
     * @return
     */
    @RequestMapping("/destroy")
    @ResponseBody
    public String destroySessionInfo(HttpSession session) {
        session.setMaxInactiveInterval(1);
        return "true";
    }

    /**
     * 根据卡号查询账户信息
     *
     * @param cardNo
     * @return
     */
    @RequestMapping(value = "/queryCardNo/{cardNo}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryCardNoInfo(@PathVariable("cardNo") String cardNo, Model model) {
        Account Account = accountService.queryCardNoAccountInfo(cardNo);
        model.addAttribute("welcome", "OK");
        model.addAttribute("balances", Account.getBalance());
        return "record";
    }

    /**
     * 修改用户密码
     *
     * @return
     */
    @Transactional
    @RequestMapping(value = "/update/{cardNoPwd}/{newPwd}/{cardNo}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String updatePasswordInfo(@PathVariable("cardNoPwd") String cardNoPwd,
                                     @PathVariable("newPwd") String newPwd,
                                     @PathVariable("cardNo") String cardNo) {
        String info = null;
        //判断卡号跟密码是否正确
        int num = accountService.queryCardNoPassword(cardNo, cardNoPwd);
        if (num <= 0) {
            return info = "旧密码输入错误";
        } else {
            //修改密码
            int num2 = accountService.updateCardNoPassword(cardNo, newPwd);
            if (num2 > 0) {
                return info = "true";
            } else {
                info = "密码修改失败";
            }
        }
        return info;
    }
}
