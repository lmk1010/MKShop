package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbUserRole;

public interface TbUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbUserRole record);

    int insertSelective(TbUserRole record);

    TbUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUserRole record);

    int updateByPrimaryKey(TbUserRole record);
}