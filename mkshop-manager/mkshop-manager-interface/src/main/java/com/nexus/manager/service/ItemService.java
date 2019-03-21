package com.nexus.manager.service;

import com.nexus.common.model.ServerResponse;
import com.nexus.manager.dto.Item;

public interface ItemService {


    //上架商品
    public ServerResponse addItem(Item item);

}
