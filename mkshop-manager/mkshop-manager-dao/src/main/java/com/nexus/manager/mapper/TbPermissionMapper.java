package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbPermission;
import org.apache.ibatis.annotations.Param;

import java.security.Permission;
import java.util.List;

public interface TbPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbPermission record);

    int insertSelective(TbPermission record);

    TbPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbPermission record);

    int updateByPrimaryKey(TbPermission record);

    List<TbPermission> selectPermByRoleIds(@Param("permIds") List<Long> permIds);
}