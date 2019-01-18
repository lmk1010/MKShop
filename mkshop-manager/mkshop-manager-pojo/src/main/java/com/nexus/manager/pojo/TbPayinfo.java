package com.nexus.manager.pojo;

import java.util.Date;

public class TbPayinfo {
    private Long id;

    private Long orderNum;

    private Long userId;

    private String paymentType;

    private String paymentNumber;

    private String paymentStatus;

    private Date createTime;

    private Date updateTime;

    public TbPayinfo(Long id, Long orderNum, Long userId, String paymentType, String paymentNumber, String paymentStatus, Date createTime, Date updateTime) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber == null ? null : paymentNumber.trim();
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus == null ? null : paymentStatus.trim();
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