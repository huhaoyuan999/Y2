package com.pojo;

import java.io.Serializable;

/**
 * 账户信息表实体类
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 3741358553926792249L;

    private Integer id;//' 编号'
    private String cardNo;//卡号
    private String password;//密码
    private float balance;//账户余额
    private Integer status;//账户状态(1 为正常，0 为冻结)

    public Account() {
    }

    public Account(Integer id, String cardNo, String password, float balance, Integer status) {
        this.id = id;
        this.cardNo = cardNo;
        this.password = password;
        this.balance = balance;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
