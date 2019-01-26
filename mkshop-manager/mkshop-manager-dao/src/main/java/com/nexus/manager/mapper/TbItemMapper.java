package com.nexus.manager.mapper;

import com.nexus.manager.pojo.TbItem;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    //CartService 检测库存
    Integer selectStockByItemId(@Param("itemId") long itemId);
    //CartService 更新商品库存
    Integer updateStockByItemId(@Param("itemId") long itemId,@Param("stockNew") Integer stockNew);
    //ItemService 根据itemID 查询商品信息
    TbItem selectByItemId(@Param("itemId") long itemId);
    //ItemService 根据ItemIdS 查询遍历
    List<TbItem> selectByItemIds(@Param("sorted") String sorted,
                                 @Param("priceH") BigDecimal priceH,
                                 @Param("priceL") BigDecimal priceL,
                                 @Param("categoryIds") List<Long> categoryIds);

}