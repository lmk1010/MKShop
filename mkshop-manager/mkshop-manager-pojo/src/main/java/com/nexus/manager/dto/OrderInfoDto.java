package com.nexus.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName OrderInfoDto
 * @Description TODO 此model是用于前端发送创建订单需要的信息
 * @Author liumingkang
 * @Date 2019-01-18 14:55
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoDto implements Serializable {

    //当前用户ID
    private long user_id;
    //用户选中的收货地址
    private long address_id;
    //购买的商品ID
    private long item_id;
    //购买的数量
    private Integer quantity;
    //总金额
    private double total_price;




}
