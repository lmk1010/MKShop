package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_order_item;

public interface tb_order_itemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_order_item record);

    int insertSelective(tb_order_item record);

    tb_order_item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_order_item record);

    int updateByPrimaryKey(tb_order_item record);
}