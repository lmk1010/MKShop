package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_address;

public interface tb_addressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_address record);

    int insertSelective(tb_address record);

    tb_address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_address record);

    int updateByPrimaryKey(tb_address record);
}