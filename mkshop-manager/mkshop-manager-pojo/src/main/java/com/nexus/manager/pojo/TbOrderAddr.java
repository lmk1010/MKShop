package com.nexus.manager.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbOrderAddr implements Serializable {
    private Long orderNum;

    private Long addressId;

    private Date createTime;

    private Date updateTime;

    public TbOrderAddr(Long orderNum, Long addressId, Date createTime, Date updateTime) {
        this.orderNum = orderNum;
        this.addressId = addressId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbOrderAddr() {
        super();
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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