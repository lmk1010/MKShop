package com.nexus.manager.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbOrder implements Serializable {
    private Long id;

    private Long orderNum;

    private Long userId;

    private BigDecimal payment;

    private Integer paymentType;

    private Date paymentTime;

    private Integer status;

    private Long expressCost;

    private Date sendTime;

    private Date finishTime;

    private Date closeTime;

    private String clientMessage;

    private Date createTime;

    private Date updateTime;

    public TbOrder(Long id, Long orderNum, Long userId, BigDecimal payment, Integer paymentType, Date paymentTime, Integer status, Long expressCost, Date sendTime, Date finishTime, Date closeTime, String clientMessage, Date createTime, Date updateTime) {
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

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
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

    public Long getExpressCost() {
        return expressCost;
    }

    public void setExpressCost(Long expressCost) {
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