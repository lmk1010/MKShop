package com.nexus.generator.pojo;

import java.util.Date;

public class tb_address {
    private Integer id;

    private Integer userId;

    private String receiveName;

    private String receiveAddress;

    private String receivePhone;

    private String receiveProvince;

    private String receiveCity;

    private String receivePostCode;

    private Date createTime;

    private Date updateTime;

    public tb_address(Integer id, Integer userId, String receiveName, String receiveAddress, String receivePhone, String receiveProvince, String receiveCity, String receivePostCode, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.receiveName = receiveName;
        this.receiveAddress = receiveAddress;
        this.receivePhone = receivePhone;
        this.receiveProvince = receiveProvince;
        this.receiveCity = receiveCity;
        this.receivePostCode = receivePostCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public tb_address() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName == null ? null : receiveName.trim();
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress == null ? null : receiveAddress.trim();
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone == null ? null : receivePhone.trim();
    }

    public String getReceiveProvince() {
        return receiveProvince;
    }

    public void setReceiveProvince(String receiveProvince) {
        this.receiveProvince = receiveProvince == null ? null : receiveProvince.trim();
    }

    public String getReceiveCity() {
        return receiveCity;
    }

    public void setReceiveCity(String receiveCity) {
        this.receiveCity = receiveCity == null ? null : receiveCity.trim();
    }

    public String getReceivePostCode() {
        return receivePostCode;
    }

    public void setReceivePostCode(String receivePostCode) {
        this.receivePostCode = receivePostCode == null ? null : receivePostCode.trim();
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