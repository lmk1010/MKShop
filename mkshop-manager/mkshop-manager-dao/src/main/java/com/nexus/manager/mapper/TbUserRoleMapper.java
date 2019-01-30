package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbUserRole;
import org.apache.ibatis.annotations.Param;

import javax.management.relation.Role;
import java.util.List;

public interface TbUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbUserRole record);

    int insertSelective(TbUserRole record);

    TbUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUserRole record);

    int updateByPrimaryKey(TbUserRole record);

    List<Long> selectAllRoleByUserId(@Param("userId") long userId);
}