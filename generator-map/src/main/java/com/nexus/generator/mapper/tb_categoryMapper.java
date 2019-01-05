package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_category;

public interface tb_categoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_category record);

    int insertSelective(tb_category record);

    tb_category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_category record);

    int updateByPrimaryKey(tb_category record);
}