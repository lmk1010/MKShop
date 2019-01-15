package com.nexus.generator.mapper;

import com.nexus.generator.pojo.TbMember;

public interface TbMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbMember record);

    int insertSelective(TbMember record);

    TbMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbMember record);

    int updateByPrimaryKey(TbMember record);
}