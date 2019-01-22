package com.nexus.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName Cart
 * @Description TODO 用于返回购物车信息
 * @Author liumingkang
 * @Date 2019-01-21 15:53
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {

    private List<CartItem> cartItemList;

    private Integer allChecked;

    private BigDecimal cartTotalPrice;



}
