package com.nexus.manager.service.impl;

import com.nexus.manager.mapper.TbAddressMapper;
import com.nexus.manager.pojo.TbAddress;
import com.nexus.manager.service.AddressService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @ClassName AdressServiceImpl
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-12 14:04
 * @Version 1.0
 **/
@Service("addressService")
@Transactional
@Log4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    private TbAddressMapper tbAddressMapper;

    @Override
    public List<TbAddress> getAllAddress(long userId) {
        return null;
    }

    @Override
    public Integer updateAddress(long addressId, long userId) {
        return null;
    }

    @Override
    public Integer deleteAddress(long addressId, long userId) {
        return null;
    }
}
