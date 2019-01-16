package com.nexus.front.service;


import com.nexus.common.model.ServerResponse;
import com.nexus.manager.pojo.TbAddress;

public interface AddressService {

    //获取当前该用户的所有收货地址
    public ServerResponse getAddressList(long userId);
    //新增收货地址
    public ServerResponse addAddress(TbAddress tbAddress);
    //更新收货地址
    public ServerResponse updateAddress(TbAddress tbAddress);
    //删除收货地址
    public ServerResponse deleteAddress(TbAddress tbAddress);



}
