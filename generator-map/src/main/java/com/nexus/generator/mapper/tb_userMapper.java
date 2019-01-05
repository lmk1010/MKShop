package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_user;

public interface tb_userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_user record);

    int insertSelective(tb_user record);

    tb_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_user record);

    int updateByPrimaryKey(tb_user record);
}