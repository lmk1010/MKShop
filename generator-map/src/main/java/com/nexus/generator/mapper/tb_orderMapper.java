package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_order;

public interface tb_orderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_order record);

    int insertSelective(tb_order record);

    tb_order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_order record);

    int updateByPrimaryKey(tb_order record);
}