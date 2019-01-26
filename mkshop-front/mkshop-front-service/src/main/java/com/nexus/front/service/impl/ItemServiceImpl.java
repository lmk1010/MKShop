package com.nexus.front.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.nexus.common.model.Constant;
import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.PropertiesUtil;
import com.nexus.front.service.ItemService;
import com.nexus.manager.dto.Item;
import com.nexus.manager.mapper.TbCategoryMapper;
import com.nexus.manager.mapper.TbItemMapper;
import com.nexus.manager.pojo.TbCategory;
import com.nexus.manager.pojo.TbItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

        TbItem tbItem = tbItemMapper.selectByItemId(itemId);
        if (tbItem==null){
            return ServerResponse.createByErrorMsg("无此商品");
        }
        return ServerResponse.createBySuccess(this.ConvertToItemDto(tbItem), "获取商品信息成功");
    }

    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 获取全部商品 没有考虑到后续一些例如销量排序 或者信用排序 目前只是价格排序
     * @Date 2019-01-26
     * @Param [pageNum, pageSize, categoreId, sorted, priceH, priceL]
     * @Return com.nexus.common.model.ServerResponse
     */
    @Override
    public ServerResponse getAllItem(int pageNum, int pageSize, long categoryId, String sorted, int priceH, int priceL) {
        //设置排序默认以金额排序
        String orderTag = "price";

        //由于默认排序为desc 分类为00000即最高父类
        //去除sorted传输参数错误
        switch (sorted){
            case "desc":break;
            case "asc":break;
            default:return ServerResponse.createByErrorMsg("参数错误!");
        }
        //先查categoryId下的所有分类
        List<TbCategory> tbCategoryList= tbCategoryMapper.selectChildId(categoryId);
        //新建子分类ID集合
        List<Long> categoryIds = Lists.newArrayList();
        //对分类进行遍历
        for (TbCategory tcate : tbCategoryList){
            if (tcate.getStatus().equals(Constant.CategoryStatusCode.DISABLED)){
                continue;
            }
            categoryIds.add(tcate.getId());
        }
        //设置分页
        PageHelper.startPage(pageNum,pageSize);
        //获得结果
        List<TbItem> tbItems = tbItemMapper.selectByItemIds(sorted, new BigDecimal(priceH),
                new BigDecimal(priceL), categoryIds);
        //分页DTO list返回
        List<Item> itemList = Lists.newArrayList();
        itemList = this.ConvertToItemDto(tbItems);
        //进行分页
        PageInfo pageInfo = new PageInfo(tbItems);
        //重新设置pageinfo内的list为DTO类型
        pageInfo.setList(itemList);
        if (tbItems==null){
            return ServerResponse.createByErrorMsg("未查询到任何数据");
        }
        return ServerResponse.createBySuccess(pageInfo, "获取商品页数据成功");
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

    private List<Item> ConvertToItemDto(List<TbItem> tbItemList){
        List<Item> itemList = Lists.newArrayList();

        for (TbItem ti:tbItemList){
            itemList.add(this.ConvertToItemDto(ti));
        }

        return itemList;
    }
}
