package com.nexus.front.service;

import com.nexus.common.model.ServerResponse;
import com.nexus.manager.dto.Item;

public interface ItemService {

    //根据商品ID查询商品
    public ServerResponse getItem(long itemId);

    //获取全部商品
    public ServerResponse getAllItem(int pageNum,int pageSize,long categoryId,String sorted,int priceH,int priceL);


}
