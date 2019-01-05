package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_payinfo;

public interface tb_payinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_payinfo record);

    int insertSelective(tb_payinfo record);

    tb_payinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_payinfo record);

    int updateByPrimaryKey(tb_payinfo record);
}