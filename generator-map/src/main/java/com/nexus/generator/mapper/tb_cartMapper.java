package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_cart;

public interface tb_cartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_cart record);

    int insertSelective(tb_cart record);

    tb_cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_cart record);

    int updateByPrimaryKey(tb_cart record);
}