package com.nexus.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDto
 * @Description TODO 返回给前端显示全部订单页
 * @Author liumingkang
 * @Date 2019-01-18 16:01
 * @Version 1.0
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
public class OrderDto implements Serializable {

    //订单号
    private long orderNum;
    //订单的付款金额
    private BigDecimal payment;
    //订单的付款方式
    private Integer paymentType;
    //订单的付款时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date paymentTime;
    //订单状态
    private Integer status;
    //订单中商品的详情
    private List<OrderItemDto> orderItemDtoList;
    //订单的创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String sendTime;
    //订单的完成时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String finishTime;
    //订单的关闭时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String closeTime;
    //订单的收货地址
    private Address addressInfo;

}
