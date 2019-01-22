package com.nexus.manager.mapper;

import com.nexus.manager.dto.CartItem;
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

    //根据userId来查询所有的购物车条目
    List<TbCart> selectByUserId(@Param("userId") long userId);

    //根据userId来连接查询cart和item表的字段
    List<CartItem> selectItemByUserId(@Param("userId") long userId);

    //查询
    TbCart selectItemByUserIdAndItemId(@Param("userId") long userId,@Param("itemId") long itemId);

    //删除cart
    Integer deleteItemByUserIdAndItemId(@Param("userId") long userId,@Param("itemId") long itemId);

    //全选中
    Integer updateAllCheckedByUserId(@Param("userId") long userId);

    //删除cart
    Integer deleteItemByUserId(@Param("userId") long userId);

}