package com.nexus.front.controller;

import com.nexus.common.model.ServerResponse;
import com.nexus.front.service.ItemService;
import com.nexus.manager.dto.Item;
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

    @RequestMapping(value = "getAllItem",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "获取全部商品",
            produces = "application/json;charset=UTF-8",notes = "获取全部item商品")
    public ServerResponse toGetAllItem(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pageSize",defaultValue = "20") int pageSize,
                                       @RequestParam(value = "sorted",defaultValue = "desc") String sorted,
                                       @RequestParam(value = "categoryId",defaultValue = "00000") long categoryId,
                                       @RequestParam(value = "priceH",defaultValue = "-1") int priceH,
                                       @RequestParam(value = "priceL",defaultValue = "-1") int peiceL){


        return itemService.getAllItem(pageNum, pageSize, categoryId, sorted, priceH, peiceL);
    }



    @RequestMapping(value = "getItem",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "GET",value = "获取商品信息",
            produces = "application/json;charset=UTF-8",notes = "对于单个itemID获取商品信息")
    public ServerResponse toGetItemDetail(@RequestParam("itemId") long itemID){
        return itemService.getItem(itemID);
    }



}
