package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 交易记录表业务逻辑接口
 */
public interface TransactionService {

    /**
     * 添加交易记录信息
     *
     * @param transaction
     * @return
     */
    public int insertTransactionInfo(Transaction transaction);

    /**
     * 根据时间范围查询交易记录
     *
     * @param before
     * @param after
     * @return
     */
    public PageInfo<Transaction> queryTransactionInfo(Date before, Date after, Integer pageNo, Integer pageSize);

}
