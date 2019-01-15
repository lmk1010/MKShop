package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbCategory;

public interface TbCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbCategory record);

    int insertSelective(TbCategory record);

    TbCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbCategory record);

    int updateByPrimaryKey(TbCategory record);
}