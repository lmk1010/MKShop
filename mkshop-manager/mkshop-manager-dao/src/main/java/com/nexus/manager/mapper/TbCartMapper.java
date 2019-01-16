package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbCart record);

    int insertSelective(TbCart record);

    TbCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbCart record);

    int updateByPrimaryKey(TbCart record);

    List<TbCart> selectByUserId(@Param("userId") long userId);
}