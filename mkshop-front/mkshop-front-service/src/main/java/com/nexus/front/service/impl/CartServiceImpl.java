package com.nexus.front.service.impl;

import com.nexus.front.service.CartService;
import com.nexus.manager.dto.CartItem;
import com.nexus.manager.mapper.TbCartMapper;
import com.nexus.manager.pojo.TbCart;
import com.nexus.manager.pojo.TbItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName CartServiceImpl
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-16 18:28
 * @Version 1.0
 **/
@Service("cartService")
@Transactional
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private TbCartMapper tbCartMapper;

    @Override
    public List<CartItem> getCartByUser(long user_id) {
        return null;
    }
}
