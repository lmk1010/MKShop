package com.nexus.generator.mapper;

import com.nexus.generator.pojo.TbCategory;

public interface TbCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCategory record);

    int insertSelective(TbCategory record);

    TbCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCategory record);

    int updateByPrimaryKey(TbCategory record);
}