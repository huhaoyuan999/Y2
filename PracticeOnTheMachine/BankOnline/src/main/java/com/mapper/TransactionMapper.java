package com.mapper;

import com.pojo.Transaction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 交易记录表DAO接口
 */
@Repository("transactionMapper")
public interface TransactionMapper {

    /**
     * 添加交易记录信息
     *
     * @param transaction
     * @return
     */
    public int insertTransactionInfo(Transaction transaction);

    /**
     * 根据时间范围查询交易记录
     * @param before
     * @param after
     * @return
     */
    public List<Transaction> queryTransactionInfo(@Param("before") Date before, @Param("after") Date after);

}
