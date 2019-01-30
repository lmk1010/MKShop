package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface TbUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    TbUser selectByUserName(@Param("username") String username);

    Set<String> selectAllPermission(@Param("username") String username);

    Set<String> selectAllRoles(@Param("username") String username);


}