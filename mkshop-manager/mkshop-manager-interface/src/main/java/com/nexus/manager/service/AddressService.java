package com.nexus.manager.service;

import com.nexus.manager.pojo.TbAddress;
import com.nexus.manager.vo.AddressVo;
import sun.jvm.hotspot.debugger.Address;

import java.util.List;

/**
 * @ClassName AddressService
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-12 14:05
 * @Version 1.0
 **/
public interface AddressService {

    //返回用户收货地址
    public List<TbAddress> getAllAddress(long userId);
    //更新某用户收货地址
    public Integer updateAddress(long addressId,long userId);
    //删除收货地址
    public Integer deleteAddress(long addressId,long userId);

}
