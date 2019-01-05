package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbCart;

public interface TbCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCart record);

    int insertSelective(TbCart record);

    TbCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCart record);

    int updateByPrimaryKey(TbCart record);
}