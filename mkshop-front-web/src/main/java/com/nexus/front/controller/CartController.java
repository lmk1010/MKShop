package com.nexus.front.controller;

import com.nexus.common.model.ServerResponse;
import com.nexus.front.service.CartService;
import com.nexus.manager.dto.Cart;
import com.nexus.manager.dto.CartInfo;
import com.nexus.manager.pojo.TbCart;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CartService cartService;


    @RequestMapping(value = "get_item_list",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "获取购物车里所有的商品",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toGetItemListFromCart(@RequestBody CartInfo cartInfo){
        return cartService.getCartByUser(cartInfo);
    }

    @RequestMapping(value = "add_item",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "添加商品到购物车",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toAddItemToCart(@RequestBody CartInfo cartInfo){
        return cartService.addCart(cartInfo);
    }

    @RequestMapping(value = "del_item",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "删除此商品中的购物车",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toDeleteItemFromCart(@RequestBody CartInfo cartInfo){
        return cartService.delCart(cartInfo);
    }

    @RequestMapping(value = "edit_item",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "更新购物车中的商品",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toEditItemFromCart(@RequestBody CartInfo cartInfo){
        return cartService.editCart(cartInfo);
    }

    @RequestMapping(value = "del_item_checked",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "清空已选中的商品",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toDeleteItemCheckedFromCart(@RequestBody CartInfo cartInfo){
        return cartService.editCart(cartInfo);
    }

    @RequestMapping(value = "check_all",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "全选",
            produces = "application/json;charset=UTF-8",notes = "传入cartInfo")
    public ServerResponse toCheckedAllFromCart(@RequestBody CartInfo cartInfo){
        return cartService.checkedAllCartItem(cartInfo);
    }

    @RequestMapping(value = "clean_all",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "清空该用户购物车内所有商品",
            produces = "application/json;charset=UTF-8",notes = "传入TBCART")
    public ServerResponse toCleanAllItemFromCart(@RequestBody CartInfo cartInfo){
        return cartService.cleanCart(cartInfo.getUserId());
    }





}
