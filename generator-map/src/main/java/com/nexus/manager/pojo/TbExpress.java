package com.nexus.manager.pojo;

import java.util.Date;

public class TbExpress {
    private Long id;

    private Integer expressCode;

    private String expressName;

    private Date createTime;

    private Date updateTime;

    public TbExpress(Long id, Integer expressCode, String expressName, Date createTime, Date updateTime) {
        this.id = id;
        this.expressCode = expressCode;
        this.expressName = expressName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbExpress() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(Integer expressCode) {
        this.expressCode = expressCode;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
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