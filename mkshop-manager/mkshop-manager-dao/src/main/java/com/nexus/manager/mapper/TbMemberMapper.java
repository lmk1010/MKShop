package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbMember;
import org.apache.ibatis.annotations.Param;

public interface TbMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbMember record);

    int insertSelective(TbMember record);

    TbMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbMember record);

    int updateByPrimaryKey(TbMember record);

    TbMember selectByUsername(@Param("username") String username);

    TbMember selectByPhone(@Param("phonenumber") String phonenumber);
}