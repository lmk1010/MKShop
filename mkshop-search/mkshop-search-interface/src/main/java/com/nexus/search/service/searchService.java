package com.nexus.search;

import com.nexus.common.model.ServerResponse;

/**
 * @ClassName com.nexus.search.searchService
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-02-17 21:40
 * @Version 1.0
 **/
public interface searchService {

    //搜索ES
    public ServerResponse search(String keyword,int pageNum,int pageSize,String desc,int priceH,int priceL);


}