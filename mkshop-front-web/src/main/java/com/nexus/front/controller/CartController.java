package com.nexus.front.controller;

import com.nexus.common.model.ServerResponse;
import com.nexus.manager.pojo.TbCart;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CartController
 * @Description TODO 购物车的增加商品和删除商品和编辑商品，以及查看购物车内是否全部选中
 * @Author liumingkang
 * @Date 2019-01-16 18:09
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/cart/")
@Api("购物车服务")
public class CartController {


    @RequestMapping(value = "get_item_list",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "获取购物车里所有的商品",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toGetItemListFromCart(@RequestParam("userId") long userId){
        return null;
    }


    @RequestMapping(value = "add_item",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "添加商品到购物车",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toAddItemToCart(@RequestBody TbCart tbCart){
        return null;
    }

    @RequestMapping(value = "del_item",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "删除此商品中的购物车",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toDeleteItemFromCart(@RequestBody TbCart tbCart){
        return null;
    }

    @RequestMapping(value = "edit_item",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "更新购物车中的商品",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toEditItemFromCart(@RequestBody TbCart tbCart){
        return null;
    }

    @RequestMapping(value = "del_item_checked",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "清空已选中的商品",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toDeleteItemCheckedFromCart(@RequestBody TbCart tbCart){
        return null;
    }




}
