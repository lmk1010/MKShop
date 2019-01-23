package com.nexus.front.service;

import com.nexus.common.model.ServerResponse;
import com.nexus.manager.dto.OrderInfo;

public interface OrderService {

    public ServerResponse getOrder(long user_id,int pageNum,int pageSize);
    
    public ServerResponse createOrder(OrderInfo orderInfo);

    public ServerResponse disableOrder(long orderNum);
    
    
}
