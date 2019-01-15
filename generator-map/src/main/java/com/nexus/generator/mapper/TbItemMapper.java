package com.nexus.generator.mapper;

import com.nexus.generator.pojo.TbItem;

public interface TbItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);
}