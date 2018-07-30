package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易记录表实体类
 */
public class Transaction implements Serializable {
    private static final long serialVersionUID = 3741358553926792249L;

    private Integer id;//记录 id
    private String cardNo;//卡号(对应account表cardNo字段)
    private Date transactionDate;//交易日期
    private float transactionAmount;//交易额
    private float balance;//账户余额
    private String transactionType;//交易类型
    private String remark;//备注

    public Transaction() {
    }

    public Transaction(Integer id, String cardNo, Date transactionDate, float transactionAmount, float balance, String transactionType, String remark) {
        this.id = id;
        this.cardNo = cardNo;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.balance = balance;
        this.transactionType = transactionType;
        this.remark = remark;
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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
