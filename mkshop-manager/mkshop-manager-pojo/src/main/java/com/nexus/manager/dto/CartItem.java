package com.nexus.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName CartItem
 * @Description TODO 作为购物车中的显示数据类 由cart和item拼接之后的数据承载对象
 * @Author liumingkang
 * @Date 2019-01-16 18:37
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem implements Serializable {

    //返回购物车条目ID
    private long id;
    //返回用户ID
    private long userId;
    //返回商品ID
    private long itemId;
    //返回商品的标题
    private String title;
    //返回商品的小标题
    private String subtitle;
    //返回商品的主图
    private String main_image;
    //返回商品的小图
    private String sub_image;
    //返回商品的单价
    private BigDecimal price;
    //返回商品的数量
    private Integer quantity;
    //返回商品的总价
    private BigDecimal totalPrice;
    //返回商品的库存
    private Integer stock;
    //返回商品的选中
    private Integer checked;



}
