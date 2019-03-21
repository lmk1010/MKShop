package com.nexus.manager.service.impl;

import com.nexus.common.model.ServerResponse;
import com.nexus.manager.dto.Item;
import com.nexus.manager.mapper.TbItemMapper;
import com.nexus.manager.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

/**
 * @ClassName ItemServiceImpl
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-02-18 15:07
 * @Version 1.0
 **/
@Service
@Transactional
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private AmqpTemplate itemTemplate;

    @Override
    public ServerResponse addItem(Item item) {
        //todo Item插入


        //todo rabbitMQ发送消息給ES 更新索引
        log.info("发送信息更新索引库");
        itemTemplate.convertAndSend("hello 更新索引啦");


        return ServerResponse.createBySuccessMsg("更新索");
    }
}
