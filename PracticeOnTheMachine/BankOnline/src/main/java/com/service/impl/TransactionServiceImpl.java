package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.TransactionMapper;
import com.pojo.Transaction;
import com.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 交易记录表业务逻辑接口实现类
 */
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
    //声明DAO类接口
    @Autowired
    @Qualifier("transactionMapper")
    private TransactionMapper transactionMapper;

    /**
     * 添加交易记录信息
     *
     * @param transaction
     * @return
     */
    @Override
    public int insertTransactionInfo(Transaction transaction) {
        //调用DAO接口方法
        return transactionMapper.insertTransactionInfo(transaction);
    }

    /**
     * 根据时间范围查询交易记录
     *
     * @param before
     * @param after
     * @return
     */
    @Override
    public PageInfo<Transaction> queryTransactionInfo(Date before, Date after, Integer pageNo, Integer pageSize) {
        //调用页面助手
        PageHelper.startPage(pageNo, pageSize);
        //调用DAO接口方法
        List<Transaction> list = transactionMapper.queryTransactionInfo(before, after);
        //调用页面助手构造器
        PageInfo<Transaction> pageInfo = new PageInfo<Transaction>(list);
        return pageInfo;
    }


}
