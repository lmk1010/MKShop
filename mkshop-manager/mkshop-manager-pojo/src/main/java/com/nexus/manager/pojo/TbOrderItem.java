package com.nexus.manager.pojo;

import java.util.Date;

public class TbOrderItem {
    private Long id;

    private Long orderNum;

    private Long itemId;

    private String itemName;

    private String itemImage;

    private Integer quantity;

    private Double unitPrice;

    private Double totalPrice;

    private Date createTime;

    private Date updateTime;

    public TbOrderItem(Long id, Long orderNum, Long itemId, String itemName, String itemImage, Integer quantity, Double unitPrice, Double totalPrice, Date createTime, Date updateTime) {
        this.id = id;
        this.orderNum = orderNum;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbOrderItem() {
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage == null ? null : itemImage.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
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