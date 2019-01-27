package com.nexus.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Item
 * @Description TODO 返回给APP或者前端的json model
 * @Author liumingkang
 * @Date 2019-01-25 12:16
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
public class Item implements Serializable {

    private long id;

    private long categoryId;

    private long parentCategoryId;

    private String title;

    private String subtitle;

    private String mainImage;

    private String subImage;

    private BigDecimal price;

    private Integer stock;

    private String detail;

    private String imageHost;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

}
