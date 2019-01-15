package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbPermission;

public interface TbPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbPermission record);

    int insertSelective(TbPermission record);

    TbPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbPermission record);

    int updateByPrimaryKey(TbPermission record);
}