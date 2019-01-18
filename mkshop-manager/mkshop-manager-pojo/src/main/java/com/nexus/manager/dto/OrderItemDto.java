package com.nexus.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName OrderItemDto
 * @Description TODO 订单中商品的详情
 * @Author liumingkang
 * @Date 2019-01-18 16:16
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto implements Serializable {

    //订单号
    private Long orderNum;
    //商品ID
    private Long itemId;
    //商品名称
    private String itemName;
    //商品的小图
    private String itemImage;
    //商品购买的数量
    private Integer quantity;
    //商品的单价
    private BigDecimal unitPrice;
    //商品的总价
    private BigDecimal totalPrice;




}
