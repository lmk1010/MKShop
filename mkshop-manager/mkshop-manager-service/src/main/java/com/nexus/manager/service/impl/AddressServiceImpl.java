package com.nexus.manager.service.impl;

import com.nexus.manager.mapper.TbAddressMapper;
import com.nexus.manager.pojo.TbAddress;
import com.nexus.manager.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @ClassName AdressServiceImpl
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-12 14:04
 * @Version 1.0
 **/
public class AddressServiceImpl implements AddressService {

    @Autowired
    private TbAddressMapper tbAddressMapper;

    @Override
    public List<TbAddress> getAllAddress(Integer userId) {
        return tbAddressMapper.selectByUserId(userId);
    }

    @Override
    public Integer updateAddress(Integer addressId, Integer userId) {
        return null;
    }

    @Override
    public Integer deleteAddress(Integer addressId, Integer userId) {
        return null;
    }
}
