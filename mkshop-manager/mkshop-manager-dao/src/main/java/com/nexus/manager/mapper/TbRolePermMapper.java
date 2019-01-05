package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbRolePerm;

public interface TbRolePermMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbRolePerm record);

    int insertSelective(TbRolePerm record);

    TbRolePerm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbRolePerm record);

    int updateByPrimaryKey(TbRolePerm record);
}