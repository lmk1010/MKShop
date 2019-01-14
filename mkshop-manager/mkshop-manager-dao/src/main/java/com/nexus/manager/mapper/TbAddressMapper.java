package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbAddress record);

    int insertSelective(TbAddress record);

    TbAddress selectByPrimaryKey(Integer id);

    List<TbAddress> selectByUserId(@Param("userId") Integer userId);

    int updateByPrimaryKeySelective(TbAddress record);

    int updateByPrimaryKey(TbAddress record);


}