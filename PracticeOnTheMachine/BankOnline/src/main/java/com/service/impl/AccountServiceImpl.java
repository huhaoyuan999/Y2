package com.service.impl;

import com.mapper.AccountMapper;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 账户信息表业务逻辑接口实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    //申明DAO类接口
    @Autowired
    @Qualifier("accountMapper")
    private AccountMapper accountMapper;

    /**
     * 查询是否有此卡号
     *
     * @param cardNo
     * @return
     */
    @Override
    public int queryCardNoInfo(String cardNo) {
        //调用DAO接口方法
        return accountMapper.queryCardNoInfo(cardNo);
    }

    /**
     * 判断卡号跟密码是否正确
     *
     * @param cardNo
     * @param password
     * @return
     */
    @Override
    public int queryCardNoPassword(String cardNo, String password) {
        //调用DAO接口方法
        return accountMapper.queryCardNoPassword(cardNo, password);
    }

    /**
     * 判断是否是正常账户
     *
     * @param cardNo
     * @param password
     * @param status
     * @return
     */
    @Override
    public int queryCardNoPasswordStatus(String cardNo, String password, Integer status) {
        //调用DAO接口方法
        return accountMapper.queryCardNoPasswordStatus(cardNo, password, status);
    }
}
