package com.service;

import org.apache.ibatis.annotations.Param;

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

}
