package com.nexus.manager.pojo;

import java.util.Date;

public class TbOrder {
    private Integer id;

    private Integer orderNum;

    private Integer userId;

    private Double payment;

    private Integer paymentType;

    private Date paymentTime;

    private Integer status;

    private Double expressCost;

    private Date sendTime;

    private Date finishTime;

    private Date closeTime;

    private String clientMessage;

    private Date createTime;

    private Date updateTime;

    public TbOrder(Integer id, Integer orderNum, Integer userId, Double payment, Integer paymentType, Date paymentTime, Integer status, Double expressCost, Date sendTime, Date finishTime, Date closeTime, String clientMessage, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNum = orderNum;
        this.userId = userId;
        this.payment = payment;
        this.paymentType = paymentType;
        this.paymentTime = paymentTime;
        this.status = status;
        this.expressCost = expressCost;
        this.sendTime = sendTime;
        this.finishTime = finishTime;
        this.closeTime = closeTime;
        this.clientMessage = clientMessage;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbOrder() {
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

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getExpressCost() {
        return expressCost;
    }

    public void setExpressCost(Double expressCost) {
        this.expressCost = expressCost;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getClientMessage() {
        return clientMessage;
    }

    public void setClientMessage(String clientMessage) {
        this.clientMessage = clientMessage == null ? null : clientMessage.trim();
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