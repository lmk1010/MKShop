package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbExpress;

public interface TbExpressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbExpress record);

    int insertSelective(TbExpress record);

    TbExpress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbExpress record);

    int updateByPrimaryKey(TbExpress record);
}