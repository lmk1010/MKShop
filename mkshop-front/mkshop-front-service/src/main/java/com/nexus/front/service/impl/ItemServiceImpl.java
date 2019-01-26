package com.nexus.front.service.impl;

import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.PropertiesUtil;
import com.nexus.front.service.ItemService;
import com.nexus.manager.dto.Item;
import com.nexus.manager.mapper.TbCategoryMapper;
import com.nexus.manager.mapper.TbItemMapper;
import com.nexus.manager.pojo.TbItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ItemServiceImpl
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-23 13:57
 * @Version 1.0
 **/
@Service("itemService")
@Transactional
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbCategoryMapper tbCategoryMapper;

    /*
     *功能描述
     * @Author liumingkang
     * @Description // 根据ID获取产品信息 返回给前端
     * @Date 2019-01-26
     * @Param [itemId]
     * @Return com.nexus.manager.dto.Item
     */
    @Override
    public ServerResponse getItem(long itemId) {

        TbItem tbItem = tbItemMapper.selectByItemID(itemId);
        if (tbItem==null){
            return ServerResponse.createByErrorMsg("无此商品");
        }
        return ServerResponse.createBySuccess(this.ConvertToItemDto(tbItem), "获取商品信息成功");
    }

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 单个转换
     * @Date 2019-01-26
     * @Param [item]
     * @Return com.nexus.manager.dto.Item
     */
    private Item ConvertToItemDto(TbItem tbItem){
        //
        Item resItem = new Item();
        //开始组装
        resItem.setId(tbItem.getId());
        //组装分类ID
        resItem.setCategoryId(tbItem.getCategoryId());
        //设置父类分类ID
        resItem.setParentCategoryId(tbCategoryMapper.selectParentId(tbItem.getCategoryId()));
        resItem.setTitle(tbItem.getTitle());
        resItem.setSubtitle(tbItem.getSubtitle());
        resItem.setMainImage(tbItem.getMainImage());
        resItem.setSubImage(tbItem.getSubImage());
        resItem.setPrice(tbItem.getPrice());
        resItem.setStock(tbItem.getStock());
        resItem.setDetail(tbItem.getDetail());
        //设置图片主机地址URL前缀 从properties中读取 在redis.properties配置文件中
        resItem.setImageHost(PropertiesUtil.getProperty("imageHost","47.94"));
        resItem.setCreateTime(tbItem.getCreateTime());
        resItem.setUpdateTime(tbItem.getUpdateTime());

        return resItem;

    }
}
