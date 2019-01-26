package com.nexus.manager.dto;

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
public class Item implements Serializable {

    private Long id;

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

    private Date createTime;

    private Date updateTime;

}
