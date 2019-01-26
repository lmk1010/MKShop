package com.nexus.front.controller;

import com.nexus.common.model.ServerResponse;
import com.nexus.front.service.ItemService;
import com.sun.tools.javac.jvm.Items;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ItemController
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-23 13:56
 * @Version 1.0
 **/
@RestController
@Api(value = "商品",description = "商品的管理获取")
@RequestMapping(value = "/api/item/")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @RequestMapping(value = "getItem",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "GET",value = "获取商品信息",
            produces = "application/json;charset=UTF-8",notes = "对于单个itemID获取商品信息")
    public ServerResponse toGetItemDetail(@RequestParam("itemId") long itemID){
        return itemService.getItem(itemID);
    }



}
