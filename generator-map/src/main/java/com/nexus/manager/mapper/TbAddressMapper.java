package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbAddress;

public interface TbAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbAddress record);

    int insertSelective(TbAddress record);

    TbAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbAddress record);

    int updateByPrimaryKey(TbAddress record);
}