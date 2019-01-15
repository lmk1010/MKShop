package com.nexus.generator.mapper;

import com.nexus.generator.pojo.TbOrderItem;

public interface TbOrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbOrderItem record);

    int insertSelective(TbOrderItem record);

    TbOrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbOrderItem record);

    int updateByPrimaryKey(TbOrderItem record);
}