package com.nexus.search.service;

import com.nexus.common.model.ServerResponse;

public interface updateIndexService {


    //更新索引
    public ServerResponse updateIndexAllItem();

    //获取es信息
    public ServerResponse getEsInfo();


}
