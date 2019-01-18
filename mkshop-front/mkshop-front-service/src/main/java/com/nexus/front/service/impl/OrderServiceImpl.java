package com.nexus.front.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.DateTimeUtil;
import com.nexus.front.service.OrderService;
import com.nexus.manager.dto.OrderDto;
import com.nexus.manager.dto.OrderInfoDto;
import com.nexus.manager.dto.OrderItemDto;
import com.nexus.manager.mapper.TbOrderItemMapper;
import com.nexus.manager.mapper.TbOrderMapper;
import com.nexus.manager.pojo.TbOrder;
import com.nexus.manager.pojo.TbOrderItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO 处理订单的创建，取消，支付
 * @Author liumingkang
 * @Date 2019-01-18 14:46
 * @Version 1.0
 **/
@Service("orderService")
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TbOrderMapper tbOrderMapper;

    @Autowired
    private TbOrderItemMapper tbOrderItemMapper;

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 根据用户ID查询此用户下的所有订单（未付款 已付款 未发货）
     * @Date 2019-01-18
     * @Param [user_id]
     * @Return com.nexus.common.model.ServerResponse
     */
    @Override
    public ServerResponse getOrder(long userId,int pageNum,int pageSize) {
        //开始分页
        PageHelper.startPage(pageNum, pageSize);
        //获取此用户的所有订单
        List<TbOrder> tbOrderList = tbOrderMapper.selectByUserId(userId);
        if (tbOrderList.isEmpty()){
            return ServerResponse.createBySuccessMsg("此用户无任何订单");
        }
        List<OrderDto> orderDtoList = this.convertOrderToDto(tbOrderList);
        PageInfo pageInfo = new PageInfo(orderDtoList);
        pageInfo.setList(orderDtoList);
        return ServerResponse.createBySuccess(pageInfo, "查询成功");
    }

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 创建订单有两种 一种为直接购买 一种为购物车结算
     * @Date 2019-01-18
     * @Param [orderInfo]
     * @Return com.nexus.common.model.ServerResponse
     */
    @Override
    public ServerResponse createOrder(OrderInfoDto orderInfo) {
        return null;
    }

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 将查询到的订单数据汇总设置到返回订单视图中
     * @Date 2019-01-18
     * @Param [tbOrderList]
     * @Return java.util.List<com.nexus.manager.dto.OrderDto>
     */
    private List<OrderDto> convertOrderToDto(List<TbOrder> tbOrderList){

        List<OrderDto> orderDtoList = new ArrayList<>();
        //遍历订单
        for (TbOrder p : tbOrderList){
            //创建返回订单视图
            OrderDto orderDto = new OrderDto();
            //设置订单号
            orderDto.setOrderNum(p.getOrderNum());
            //设置付款金额
            orderDto.setPayment(p.getPayment());
            //设置付款方式（1-在线支付）
            orderDto.setPaymentType(p.getPaymentType());
            //设置支付时间
            orderDto.setPaymentTime(p.getPaymentTime());
            //设置订单状态
            orderDto.setStatus(p.getStatus());
            //设置订单创建时间
            orderDto.setSendTime(DateTimeUtil.dateToStr(p.getSendTime()));
            //设置订单完成时间
            orderDto.setFinishTime(DateTimeUtil.dateToStr(p.getFinishTime()));
            //设置订单的关闭时间
            orderDto.setCloseTime(DateTimeUtil.dateToStr(p.getCloseTime()));

            //查询订单中商品
            List<TbOrderItem> tbOrderItemList = tbOrderItemMapper.selectByOrderNum(p.getOrderNum());
            if (tbOrderItemList==null){
                return null;
            }
            //创建订单内商品list视图
            List<OrderItemDto> orderItemDtoList = new ArrayList<>();
            for(TbOrderItem d : tbOrderItemList){
                OrderItemDto orderItemDto = new OrderItemDto();
                orderItemDto.setOrderNum(d.getOrderNum());
                orderItemDto.setItemId(d.getItemId());
                orderItemDto.setItemName(d.getItemName());
                orderItemDto.setItemImage(d.getItemImage());
                orderItemDto.setQuantity(d.getQuantity());
                orderItemDto.setUnitPrice(d.getUnitPrice());
                orderItemDto.setTotalPrice(d.getTotalPrice());
                orderItemDtoList.add(orderItemDto);
            }
            //设置订单内商品视图
            orderDto.setOrderItemDtoList(orderItemDtoList);
            //将单次订单添加入所有订单list
            orderDtoList.add(orderDto);

        }
        return orderDtoList;

    }
}
