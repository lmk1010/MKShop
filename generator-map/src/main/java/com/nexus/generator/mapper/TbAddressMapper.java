package com.nexus.generator.mapper;

import com.nexus.generator.pojo.TbAddress;

public interface TbAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbAddress record);

    int insertSelective(TbAddress record);

    TbAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbAddress record);

    int updateByPrimaryKey(TbAddress record);
}