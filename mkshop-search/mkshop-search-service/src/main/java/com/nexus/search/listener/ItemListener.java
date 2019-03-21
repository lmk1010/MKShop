package com.nexus.search.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @ClassName ItemListener
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-02-18 14:55
 * @Version 1.0
 **/
public class ItemListener implements MessageListener {

    public void onMessage(Message message)
    {
        System.err.println(message+"收到消息");
    }
}
