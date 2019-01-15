package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbRole;

public interface TbRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbRole record);

    int insertSelective(TbRole record);

    TbRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRole record);

    int updateByPrimaryKey(TbRole record);
}