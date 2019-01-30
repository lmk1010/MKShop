package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbRole record);

    int insertSelective(TbRole record);

    TbRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRole record);

    int updateByPrimaryKey(TbRole record);

    List<TbRole> selectByRoleId(@Param("roleIds") List<Long> roleIds);

}