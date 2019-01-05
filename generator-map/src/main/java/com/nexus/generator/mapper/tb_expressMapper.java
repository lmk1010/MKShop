package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_express;

public interface tb_expressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_express record);

    int insertSelective(tb_express record);

    tb_express selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_express record);

    int updateByPrimaryKey(tb_express record);
}