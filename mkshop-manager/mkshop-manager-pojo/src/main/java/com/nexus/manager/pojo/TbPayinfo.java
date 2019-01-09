package com.nexus.manager.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbPayinfo implements Serializable {
    private Integer id;

    private Integer orderNum;

    private Integer userId;

    private Integer paymentType;

    private Integer paymentNumber;

    private Integer paymentStatus;

    private Date createTime;

    private Date updateTime;

    public TbPayinfo(Integer id, Integer orderNum, Integer userId, Integer paymentType, Integer paymentNumber, Integer paymentStatus, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNum = orderNum;
        this.userId = userId;
        this.paymentType = paymentType;
        this.paymentNumber = paymentNumber;
        this.paymentStatus = paymentStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbPayinfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(Integer paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}