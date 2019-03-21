package com.nexus.front.service;

import com.nexus.common.model.ServerResponse;
import com.nexus.manager.dto.Item;

public interface ItemService {

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 根据商品ID去查询信息
     *                     返回的商品数据在ServerResponse中的Data中
     *
     * @Date 2019-03-21
     * @Param [itemId]
     * @Return com.nexus.common.model.ServerResponse
     */
    public ServerResponse getItem(long itemId);

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 获取全部的商品信息 默认传入分页 可选按价格排序 还有商品类目的分类
     * @Date 2019-03-21
     * @Param [pageNum, pageSize, categoryId, sorted, priceH, priceL]
     * @Return com.nexus.common.model.ServerResponse
     */
    public ServerResponse getAllItem(int pageNum,int pageSize,long categoryId,String sorted,int priceH,int priceL);


}
