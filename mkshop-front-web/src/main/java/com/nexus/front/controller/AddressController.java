package com.nexus.front.controller;

import com.nexus.common.model.ServerResponse;
import com.nexus.front.service.AddressService;
import com.nexus.manager.pojo.TbAddress;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AddressController
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-16 17:25
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/address/")
@Api(value = "收货地址接口")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "get_address_list",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "获取当前用户的所有收货地址",
            produces = "application/json;charset=UTF-8",notes = "传入用户ID")
    public ServerResponse toGetAddressList(@RequestParam("userId") long userId){
        return addressService.getAddressList(userId);
    }

    @RequestMapping(value = "add_address",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "新增收货地址",
            produces = "application/json;charset=UTF-8",notes = "传入address")
    public ServerResponse toAddAddress(@RequestBody TbAddress tbAddress){
        return addressService.addAddress(tbAddress);
    }

    @RequestMapping(value = "update_address",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "更新收货地址",
            produces = "application/json;charset=UTF-8",notes = "传入address")
    public ServerResponse toUpdateAddress(@RequestBody TbAddress tbAddress){
        return addressService.updateAddress(tbAddress);
    }

    @RequestMapping(value = "delete_address",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "POST",value = "删除收货地址",
            produces = "application/json;charset=UTF-8",notes = "传入address")
    public ServerResponse toDeleteAddress(@RequestBody TbAddress tbAddress){
        return addressService.deleteAddress(tbAddress);
    }




}
