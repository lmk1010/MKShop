package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbAddress;

import java.util.List;

public interface TbAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbAddress record);

    int insertSelective(TbAddress record);

    TbAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbAddress record);

    int updateByPrimaryKey(TbAddress record);

    List<TbAddress> selectAllByUserId(long userId);

}