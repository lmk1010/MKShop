package com.nexus.manager.dao;


import com.nexus.manager.pojo.tb_user;

public interface tb_userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_user record);

    int insertSelective(tb_user record);

    tb_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_user record);

    int updateByPrimaryKey(tb_user record);
}