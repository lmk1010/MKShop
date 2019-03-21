package com.nexus.search.mapper;

import com.nexus.manager.dto.Item;
import com.nexus.manager.dto.search.ItemSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ItemMapper
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-02-18 15:21
 * @Version 1.0
 **/

public interface ItemMapper {

    List<ItemSearch> getItemList();

    ItemSearch getItemById(@Param("itemId") Long itemId);

}
