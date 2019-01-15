package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbExpress;

public interface TbExpressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbExpress record);

    int insertSelective(TbExpress record);

    TbExpress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbExpress record);

    int updateByPrimaryKey(TbExpress record);
}