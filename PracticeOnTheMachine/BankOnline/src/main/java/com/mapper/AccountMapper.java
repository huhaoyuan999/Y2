package com.mapper;

import com.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 账户信息表DAO接口
 */
@Repository("accountMapper")
public interface AccountMapper {

    /**
     * 查询是否有此卡号
     *
     * @return
     */
    public int queryCardNoInfo(@Param("cardNo") String cardNo);

    /**
     * 判断卡号跟密码是否正确
     *
     * @return
     */
    public int queryCardNoPassword(@Param("cardNo") String cardNo,
                                   @Param("password") String password);


    /**
     * 判断是否是正常账户
     *
     * @return
     */
    public int queryCardNoPasswordStatus(@Param("cardNo") String cardNo,
                                         @Param("password") String password,
                                         @Param("status") Integer status);

    /**
     * 根据卡号查询账户信息
     *
     * @param cardNo
     * @return
     */
    public Account queryCardNoAccountInfo(@Param("cardNo") String cardNo);

    /**
     * 账户转入
     *
     * @return
     */
    public int UpdateInputEnter(@Param("cardNo") String cardNo, @Param("balance") float balance);

    /**
     * 账户转出
     *
     * @return
     */
    public int UpdateInputOut(@Param("cardNo") String cardNo, @Param("balance") float balance);

    /**
     * 根据卡号修改密码
     * @param cardNo
     * @param password
     * @return
     */
    public int updateCardNoPassword(@Param("cardNo") String cardNo, @Param("password") String password);
}
