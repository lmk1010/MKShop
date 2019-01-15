package com.nexus.generator.mapper;

import com.nexus.generator.pojo.TbCart;

public interface TbCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCart record);

    int insertSelective(TbCart record);

    TbCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCart record);

    int updateByPrimaryKey(TbCart record);
}