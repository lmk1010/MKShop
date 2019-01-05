package com.nexus.manager.dao;


import com.nexus.manager.pojo.tb_role;

public interface tb_roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_role record);

    int insertSelective(tb_role record);

    tb_role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_role record);

    int updateByPrimaryKey(tb_role record);
}