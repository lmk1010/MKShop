package com.nexus.generator.mapper;

import com.nexus.generator.pojo.tb_permission;

public interface tb_permissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(tb_permission record);

    int insertSelective(tb_permission record);

    tb_permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(tb_permission record);

    int updateByPrimaryKey(tb_permission record);
}