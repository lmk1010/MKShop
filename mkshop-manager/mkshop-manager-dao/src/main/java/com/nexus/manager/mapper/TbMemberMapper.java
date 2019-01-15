package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbMember;

public interface TbMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbMember record);

    int insertSelective(TbMember record);

    TbMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbMember record);

    int updateByPrimaryKey(TbMember record);
}