package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbPayinfo;

public interface TbPayinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbPayinfo record);

    int insertSelective(TbPayinfo record);

    TbPayinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbPayinfo record);

    int updateByPrimaryKey(TbPayinfo record);
}