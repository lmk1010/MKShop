package com.nexus.front.controller;

import com.nexus.common.model.ServerResponse;
import com.nexus.front.service.OrderService;
import com.nexus.manager.dto.OrderInfoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-18 15:23
 * @Version 1.0
 **/
@RestController
@Api("订单处理")
@RequestMapping(value = "/api/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "get_order_list",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "获取该用户所有订单",httpMethod = "POST",produces = "application/json;charset=UTF-8",
    notes = "需要分页查询")
    public ServerResponse getOrder(@RequestParam("userId") long userId,
                                   @RequestParam("pageNum") int pageNum,
                                   @RequestParam("pageSize") int pageSize){
        return orderService.getOrder(userId, pageNum, pageSize);
    }


    @RequestMapping(value = "create_order",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "创建订单",httpMethod = "POST",produces = "application/json;charset=UTF-8")
    public ServerResponse createOrder(@RequestBody OrderInfoDto orderInfo){
        return orderService.createOrder(orderInfo);
    }




}