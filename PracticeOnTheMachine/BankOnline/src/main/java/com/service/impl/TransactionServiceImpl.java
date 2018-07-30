package com.service.impl;

import com.mapper.TransactionMapper;
import com.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 交易记录表业务逻辑接口实现类
 */
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
    //声明DAO类接口
    @Autowired
    @Qualifier("transactionMapper")
    private TransactionMapper transactionMapper;


}
