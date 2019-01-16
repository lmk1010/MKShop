package com.nexus.front.service;

import com.nexus.manager.dto.CartItem;

import java.util.List;

public interface CartService {

    public List<CartItem> getCartByUser(long user_id);


}
