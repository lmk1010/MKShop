package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbOrder;
import com.nexus.manager.pojo.TbOrderItem;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface TbOrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbOrderItem record);

    int insertSelective(TbOrderItem record);

    TbOrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbOrderItem record);

    int updateByPrimaryKey(TbOrderItem record);

    List<TbOrderItem> selectByOrderNum(@Param("orderNum") long orderNum);
}