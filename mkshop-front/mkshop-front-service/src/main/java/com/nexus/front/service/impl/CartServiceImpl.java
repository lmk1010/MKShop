package com.nexus.front.service.impl;

import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.BigDecimalUtil;
import com.nexus.front.service.CartService;
import com.nexus.manager.dto.Cart;
import com.nexus.manager.dto.CartInfo;
import com.nexus.manager.dto.CartItem;
import com.nexus.manager.mapper.TbCartMapper;
import com.nexus.manager.mapper.TbItemMapper;
import com.nexus.manager.pojo.TbCart;
import com.nexus.manager.pojo.TbItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName CartServiceImpl
 * @Description TODO 购物车实现类
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

    @Autowired
    private TbItemMapper tbItemMapper;


    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 根据用户ID来获取该用户的购物车
     * @Date 2019-01-22
     * @Param [cartInfo]
     * @Return com.nexus.common.model.ServerResponse<com.nexus.manager.dto.Cart>
     */
    @Override
    public ServerResponse<Cart> getCartByUser(CartInfo cartInfo) {
        //只检测userID,查询数据库 获取到封装好的条目信息
        List<CartItem> cartItemList = tbCartMapper.selectItemByUserId(cartInfo.getUserId());
        if (cartItemList==null){
            return ServerResponse.createBySuccessMsg("此用户购物车中无任何商品");
        }
        Cart returnCart = this.assembleCartItem(cartItemList);
        return ServerResponse.createBySuccess(returnCart, "获取购物车信息成功");
    }

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 第一防止不存在的用户添加购物车 第二防止添加的商品无此ID后期
     * @Date 2019-01-22
     * @Param [cartInfo]
     * @Return com.nexus.common.model.ServerResponse
     */
    @Override
    public ServerResponse addCart(CartInfo cartInfo) {
        //首先验证此商品是否有库存 以此来判断是否可以加入购物车
        // todo 后续可以改进 没有库存可以加入购物车但无法下单
        Integer stockStatus = tbItemMapper.selectStockByItemId(cartInfo.getItemId());
        //查找cart是否存在
        TbCart cartStatus = tbCartMapper.selectItemByUserIdAndItemId(cartInfo.getUserId(), cartInfo.getItemId());
        if (cartStatus==null){
            //判断库存
            Integer stockNew = (stockStatus-cartInfo.getQuantity());
            if (stockNew<0){
                return ServerResponse.createBySuccessMsg("库存不足");
            }
            //如果DB中没有此购物车记录，则新增TbCart
            TbCart tbCart = new TbCart();
            tbCart.setItemId(cartInfo.getItemId());
            tbCart.setUserId(cartInfo.getUserId());
            tbCart.setChecked(cartInfo.getChecked().equals(1));
            tbCart.setQuantity(cartInfo.getQuantity());
            int insertStatus = tbCartMapper.insert(tbCart);
            if (insertStatus==0){
                return ServerResponse.createByErrorMsg("商品添加失败");
            }
        }else{
            //检测库存
            Integer stockNew = stockStatus-(cartInfo.getQuantity()+cartStatus.getQuantity());
            if (stockNew<0){
                return ServerResponse.createBySuccessMsg("库存不足");
            }

            //如果已存在 则对于选中数量和checked进行更新
            cartStatus.setQuantity(cartStatus.getQuantity()+cartInfo.getQuantity());
            cartStatus.setChecked(cartInfo.getChecked().equals(1));
            int updateStatus = tbCartMapper.updateByPrimaryKeySelective(cartStatus);
            if (updateStatus == 0){
                return ServerResponse.createByErrorMsg("商品添加失败");
            }
        }

        return ServerResponse.createBySuccessMsg("商品添加成功");
    }

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 删除购物车中的某件商品
     * @Date 2019-01-22
     * @Param [cartInfo]
     * @Return com.nexus.common.model.ServerResponse
     */
    @Override
    public ServerResponse delCart(CartInfo cartInfo) {
        Integer delStatus = tbCartMapper.deleteItemByUserIdAndItemId(cartInfo.getUserId(), cartInfo.getItemId());
        if (delStatus==0){
            return ServerResponse.createByErrorMsg("移除商品失败");
        }
        return ServerResponse.createBySuccessMsg("移除商品成功");
    }

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO更新购物车里的条目
     * @Date 2019-01-22
     * @Param [cartInfo]
     * @Return com.nexus.common.model.ServerResponse
     */
    @Override
    public ServerResponse editCart(CartInfo cartInfo) {
        //查询DB中Cart
        TbCart updateCart = tbCartMapper.selectItemByUserIdAndItemId(cartInfo.getUserId(), cartInfo.getItemId());
        //校验
        if (cartInfo.getQuantity()!=null&&cartInfo.getQuantity()!=0){
            //校验库存
            Integer stockStatus = tbItemMapper.selectStockByItemId(cartInfo.getItemId());
            Integer stockNew = stockStatus-cartInfo.getQuantity();
            if (stockNew<0){
                return ServerResponse.createBySuccessMsg("库存不足");
            }
            //更新数量属性
            updateCart.setQuantity(cartInfo.getQuantity());
        }
        //更新checked
        updateCart.setChecked(cartInfo.getChecked().equals(1));
        //更新
        int updateStatus = tbCartMapper.updateByPrimaryKeySelective(updateCart);
        if (updateStatus==0){
            return ServerResponse.createByErrorMsg("更新失败");
        }
        return ServerResponse.createBySuccessMsg("更新成功");
    }

    @Override
    public ServerResponse checkedAllCartItem(CartInfo cartInfo) {
        Integer checkedStatus = tbCartMapper.updateAllCheckedByUserId(cartInfo.getUserId());
        if (checkedStatus==0){
            return ServerResponse.createByErrorMsg("全选失败");
        }
        return ServerResponse.createBySuccessMsg("全选成功");
    }

    @Override
    public ServerResponse cleanCart(long userId) {
        Integer delStatus = tbCartMapper.deleteItemByUserId(userId);
        if (delStatus==0){
            return ServerResponse.createByErrorMsg("清空失败");
        }
        return ServerResponse.createBySuccessMsg("清空购物车成功");
    }


    private Cart assembleCartItem(List<CartItem> cartItemList){
        //创建新的Cart返回DTO对象
        Cart cart = new Cart();
        //默认购物车全选
        Integer checked = 1;
        //定义购物车总价
        BigDecimal totalCartPrice = BigDecimal.valueOf(0);
        //设置购物车中商品条目详情
        cart.setCartItemList(cartItemList);
        //遍历cartitemlist
        for (CartItem c : cartItemList){
            if (c.getChecked()==0){
                checked = 0;
            }
            //计算单件商品价格
            BigDecimal totalItemPrice = BigDecimalUtil.mulIntger(c.getPrice(), c.getQuantity());
            c.setTotalPrice(totalItemPrice);
            //计算整个购物车价格合计
            totalCartPrice = totalCartPrice.add(totalItemPrice);
        }
        //设置全选
        cart.setAllChecked(checked);
        //设置购物车总价格
        cart.setCartTotalPrice(totalCartPrice);
        return cart;
    }


}
