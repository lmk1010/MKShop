package com.nexus.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName OrderInfo
 * @Description TODO 此model是用于前端发送创建订单需要的信息
 * @Author liumingkang
 * @Date 2019-01-18 14:55
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo implements Serializable {

    //当前用户ID
    private long user_id;
    //用户选中的收货地址
    private long address_id;
    //总金额
    private BigDecimal total_price;
    //买家留言
    private String client_message;
    //需要购买的商品列表
    private List<CartItem> cartItemList;




}
