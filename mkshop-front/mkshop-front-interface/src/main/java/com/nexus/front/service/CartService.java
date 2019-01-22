package com.nexus.front.service;

import com.nexus.common.model.ServerResponse;
import com.nexus.manager.dto.Cart;
import com.nexus.manager.dto.CartInfo;
import com.nexus.manager.dto.CartItem;

import java.util.List;


public interface CartService {

    public ServerResponse<Cart> getCartByUser(CartInfo cartInfo);

    public ServerResponse addCart(CartInfo cartInfo);

    public ServerResponse delCart(CartInfo cartInfo);

    public ServerResponse editCart(CartInfo cartInfo);

    public ServerResponse checkedAllCartItem(CartInfo cartInfo);

    public ServerResponse cleanCart(long userId);

}
