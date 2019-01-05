package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_item;

public interface tb_itemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_item record);

    int insertSelective(tb_item record);

    tb_item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_item record);

    int updateByPrimaryKey(tb_item record);
}