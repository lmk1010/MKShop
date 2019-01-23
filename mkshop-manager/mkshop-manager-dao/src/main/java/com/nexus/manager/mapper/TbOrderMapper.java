package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    TbOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKey(TbOrder record);

    List<TbOrder> selectByUserId(@Param("userId") long userId);

    TbOrder selectByOrderNum(@Param("orderNum") long orderNum);
}