package com.nexus.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName CartInfo
 * @Description TODO 为客户端请求的数据model
 * @Author liumingkang
 * @Date 2019-01-21 16:13
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartInfo implements Serializable {

    //请求带有用户ID
    private long userId;
    //商品ID
    private long itemId;
    //是否选中 用于选中某件商品
    private Integer checked;
    //用于更新购物车中商品的数量
    private Integer quantity;
}
