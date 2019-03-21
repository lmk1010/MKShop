package com.nexus.manager.dto.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName ItemSearch
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-02-18 15:24
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemSearch implements Serializable {

    private long itemId;

    private String title;

    private String subtitle;

    private String mainImage;

    private BigDecimal price;

    private long categoryId;

    private String categoryName;



}
