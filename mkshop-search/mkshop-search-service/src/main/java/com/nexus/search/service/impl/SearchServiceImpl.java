package com.nexus.search.service.impl;

import com.google.gson.Gson;
import com.nexus.common.model.ServerResponse;
import com.nexus.manager.dto.search.ItemResult;
import com.nexus.manager.dto.search.ItemSearch;
import com.nexus.manager.mapper.TbItemMapper;
import com.nexus.search.mapper.ItemMapper;
import com.nexus.search.service.searchService;
import com.sun.tools.javac.jvm.Items;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

/**
 * @ClassName com.nexus.search.service.impl.SearchServiceImpl
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-02-17 21:40
 * @Version 1.0
 **/
@Service("searchService")
@Transactional
@Slf4j
public class SearchServiceImpl implements searchService {

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



    public ServerResponse search(String keyword, int pageNum, int pageSize, String desc, int priceH, int priceL) {

        ItemResult itemResult = new ItemResult();

        try{
            Settings settings = Settings.builder().put("cluster.name", ES_CLUSTER_NAME).build();

            TransportClient client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(ES_CONNECT_IP), 9300));

            //设置查询条件
            //单字段搜索
            QueryBuilder qb = matchQuery("titile",keyword);


            //设置分页
            if (pageNum <=0 ){
                pageNum =1;
            }
            int start=(pageNum - 1) * pageNum;

            SearchResponse searchResponse = null;

            if(priceH>=0&&priceL>=0&&desc.isEmpty()){
                searchResponse=client.prepareSearch(ITEM_INDEX)
                        .setTypes(ITEM_TYPE)
                        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                        .setQuery(qb)	// Query
                        .setFrom(start).setSize(pageSize).setExplain(true)	//从第几个开始，显示size个数据
                        .setPostFilter(QueryBuilders.rangeQuery("price").gt(priceH).lt(priceL))	//过滤条件
                        .get();
            }
            searchResponse=client.prepareSearch(ITEM_INDEX)
                    .setTypes(ITEM_TYPE)
                    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    .setQuery(qb)	// Query
                    .setFrom(start).setSize(pageSize).setExplain(true)	//从第几个开始，显示size个数据
                    .setPostFilter(QueryBuilders.rangeQuery("price").gt(priceH).lt(priceL))	//过滤条件
                    .addSort("price",SortOrder.DESC)
                    .get();
            SearchHits hits = searchResponse.getHits();
            //返回总结果数
            itemResult.setCount(hits.totalHits);
            List<ItemSearch> list=new ArrayList<ItemSearch>();
            if (hits.totalHits > 0) {
                for (SearchHit hit : hits) {
                    //总页数
                    int totalPage=(int) (hit.getScore()/pageSize);
                    if((hit.getScore()%pageSize)!=0){
                        totalPage++;
                    }
                    //返回结果总页数
                    itemResult.setTotalPages(totalPage);
                    //设置高亮字段
                    ItemSearch searchItem=new Gson().fromJson(hit.getSourceAsString(),ItemSearch.class);
                    String productName = hit.getHighlightFields().get("productName").getFragments()[0].toString();
                    searchItem.setTitle(productName);
                    //返回结果
                    list.add(searchItem);
                }
            }
            itemResult.setItemSearchList(list);
            //因个人服务器配置过低此处取消关闭减轻搜索压力增快搜索速度
            //client.close();

        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByErrorMsg("搜索失败");
        }

        return ServerResponse.createBySuccess(itemResult, "搜索成功");
    }

    public ServerResponse QuickSearch(String key) {


        return null;
    }
}
