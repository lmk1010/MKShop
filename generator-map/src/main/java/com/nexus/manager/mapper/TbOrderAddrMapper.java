package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbOrderAddr;

public interface TbOrderAddrMapper {
    int deleteByPrimaryKey(Long orderNum);

    int insert(TbOrderAddr record);

    int insertSelective(TbOrderAddr record);

    TbOrderAddr selectByPrimaryKey(Long orderNum);

    int updateByPrimaryKeySelective(TbOrderAddr record);

    int updateByPrimaryKey(TbOrderAddr record);
}