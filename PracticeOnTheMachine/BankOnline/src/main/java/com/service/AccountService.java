package com.service;

import com.pojo.Account;

/**
 * 账户信息表业务逻辑接口
 */
public interface AccountService {

    /**
     * 查询是否有此卡号
     *
     * @return
     */
    public int queryCardNoInfo(String cardNo);

    /**
     * 判断卡号跟密码是否正确
     *
     * @return
     */
    public int queryCardNoPassword(String cardNo, String password);

    /**
     * 判断是否是正常账户
     *
     * @return
     */
    public int queryCardNoPasswordStatus(String cardNo, String password, Integer status);

    /**
     * 根据卡号查询账户信息
     *
     * @param cardNo
     * @return
     */
    public Account queryCardNoAccountInfo(String cardNo);

    /**
     * 账户转入
     *
     * @return
     */
    public int UpdateInputEnter(String cardNo, float balance);

    /**
     * 账户转出
     *
     * @return
     */
    public int UpdateInputOut(String cardNo, float balance);

    /**
     * 根据卡号修改密码
     *
     * @param cardNo
     * @param password
     * @return
     */
    public int updateCardNoPassword(String cardNo, String password);
}
