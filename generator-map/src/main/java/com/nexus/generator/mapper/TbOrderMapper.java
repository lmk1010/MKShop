package com.nexus.generator.mapper;

import com.nexus.generator.pojo.TbOrder;

public interface TbOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    TbOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKey(TbOrder record);
}