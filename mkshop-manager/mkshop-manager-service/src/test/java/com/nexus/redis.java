package com.nexus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName redis
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-08 10:40
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class redis {

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void ted(){

        Jedis jedis = jedisPool.getResource();


        jedis.set("lmk211", "jaha");

        jedis.close();
    }



}
