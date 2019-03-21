package com.nexus.search.service.impl;

import com.google.gson.Gson;
import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.HttpUtil;
import com.nexus.manager.dto.search.EsInfo;
import com.nexus.manager.dto.search.ItemSearch;
import com.nexus.search.mapper.ItemMapper;
import com.nexus.search.service.updateIndexService;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.util.List;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @ClassName updateIndexServiceImpl
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-02-18 16:09
 * @Version 1.0
 **/
@Service("updateIndexService")
@Transactional
@Slf4j
public class updateIndexServiceImpl implements updateIndexService {

    @Autowired
    private ItemMapper itemMapper;

    @Value("${ES_CONNECT_IP}")
    private String ES_CONNECT_IP;

    @Value("${ES_NODE_CLIENT_PORT}")
    private String ES_NODE_CLIENT_PORT;

    @Value("${ES_CLUSTER_NAME}")
    private String ES_CLUSTER_NAME;

    @Value("${ITEM_INDEX}")
    private String ITEM_INDEX;

    @Value("${ITEM_TYPE}")
    private String ITEM_TYPE;


    /*
     *功能描述
     * @Author liumingkang
     * @Description //TODO 更新ES中的索引
     * @Date 2019-02-18
     * @Param []
     * @Return com.nexus.common.model.ServerResponse
     */
    public ServerResponse updateIndexAllItem() {
        try{

            Settings settings = Settings.builder().put("cluster.name", ES_CLUSTER_NAME).build();

            TransportClient client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(ES_CONNECT_IP), 9300));

            //批量添加
            BulkRequestBuilder bulkRequest = client.prepareBulk();

            //获取当前数据库里的所有商品信息
            List<ItemSearch> itemList = itemMapper.getItemList();

            for (ItemSearch item : itemList){
                bulkRequest.add(client.prepareIndex(ITEM_INDEX,ITEM_TYPE,String.valueOf(item.getItemId()))
                        .setSource(jsonBuilder().startObject()
                        .field("itemId", item.getItemId())
                        .field("categoryId", item.getCategoryId())
                        .field("categoryName", item.getCategoryName())
                        .field("titile", item.getTitle())
                        .field("subtitile", item.getSubtitle())
                        .field("mainImage", item.getMainImage())
                        .field("price", item.getPrice())
                        .endObject()));
            }

            BulkResponse bulkItemResponses = bulkRequest.get();

            client.close();

        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByErrorMsg("更新索引失败！");
        }

        return ServerResponse.createBySuccessMsg("更新索引成功");
    }

    public ServerResponse getEsInfo() {
        String healthUrl="http://"+ES_CONNECT_IP+":"+ES_NODE_CLIENT_PORT+"/_cluster/health";
        String countUrl="http://"+ES_CONNECT_IP+":"+ES_NODE_CLIENT_PORT+"/_count";
        String healthResult= HttpUtil.sendGet(healthUrl);
        String countResult=HttpUtil.sendGet(countUrl);
        if(StringUtils.isBlank(healthResult)||StringUtils.isBlank(countResult)){
            return ServerResponse.createByErrorMsg("ES集群出错，连接不上！");
        }
        EsInfo esInfo=new EsInfo();
        try {
            esInfo=new Gson().fromJson(healthResult,EsInfo.class);
        }catch (Exception e){
            e.printStackTrace();
           return ServerResponse.createByErrorMsg("出现异常");
        }

        return ServerResponse.createBySuccess(esInfo, "获取ES信息成功");

    }
}
