package com.nexus.manager.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbItem {

    private Long id;

    private Integer categoryId;

    private String title;

    private String subtitle;

    private String mainImage;

    private String subImage;

    private BigDecimal price;

    private Integer stock;

    private String detail;

    private Date createTime;

    private Date updateTime;

    public TbItem(Long id, Integer categoryId, String title, String subtitle, String mainImage, String subImage, BigDecimal price, Integer stock, String detail, Date createTime, Date updateTime) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.subtitle = subtitle;
        this.mainImage = mainImage;
        this.subImage = subImage;
        this.price = price;
        this.stock = stock;
        this.detail = detail;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbItem() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public String getSubImage() {
        return subImage;
    }

    public void setSubImage(String subImage) {
        this.subImage = subImage == null ? null : subImage.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
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