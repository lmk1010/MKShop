package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbRolePerm;

public interface TbRolePermMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbRolePerm record);

    int insertSelective(TbRolePerm record);

    TbRolePerm selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRolePerm record);

    int updateByPrimaryKey(TbRolePerm record);
}