package com.nexus.front.service.impl;

import com.nexus.common.model.ResponseCode;
import com.nexus.common.model.ServerResponse;
import com.nexus.front.service.AddressService;
import com.nexus.manager.mapper.TbAddressMapper;
import com.nexus.manager.pojo.TbAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName AddressServiceImpl
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-16 17:13
 * @Version 1.0
 **/
@Service("addressService")
@Transactional
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    private TbAddressMapper tbAddressMapper;


    @Override
    public ServerResponse getAddressList(long userId) {
        List<TbAddress> tbAddressList = tbAddressMapper.selectAllByUserId(userId);
        return ServerResponse.createBySuccess(tbAddressList, "获取列表成功");
    }

    @Override
    public ServerResponse addAddress(TbAddress tbAddress) {
        int result = tbAddressMapper.insert(tbAddress);
        if (result!=1){
            return ServerResponse.createByErrorMsg("新增收货地址失败");
        }
        return ServerResponse.createBySuccessMsg("新增收货地址成功");
    }

    @Override
    public ServerResponse updateAddress(TbAddress tbAddress) {
        int result = tbAddressMapper.updateByPrimaryKeySelective(tbAddress);
        if (result!=1){
            return ServerResponse.createByErrorMsg("更新收货地址失败");
        }
        return ServerResponse.createBySuccessMsg("更新收货地址成功");
    }

    @Override
    public ServerResponse deleteAddress(TbAddress tbAddress) {
        int result = tbAddressMapper.deleteByPrimaryKey(tbAddress.getId());
        if (result!=1){
            return ServerResponse.createByErrorMsg("删除收货地址失败");
        }
        return ServerResponse.createBySuccessMsg("删除收货地址成功");
    }
}
