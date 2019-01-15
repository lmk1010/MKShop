package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbPayinfo;

public interface TbPayinfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbPayinfo record);

    int insertSelective(TbPayinfo record);

    TbPayinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbPayinfo record);

    int updateByPrimaryKey(TbPayinfo record);
}