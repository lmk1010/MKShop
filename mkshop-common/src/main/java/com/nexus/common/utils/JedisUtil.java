package com.nexus.common.utils;

import com.nexus.common.jedis.JedisOperater;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName JedisUtil
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-07 13:19
 * @Version 1.0
 **/
public class JedisUtil implements JedisOperater {


    private JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        if (key==null){
           return null;
        }
        String result = jedis.set(key, value);
        jedis.close();
        return result;
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    @Override
    public Boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        Boolean exists = jedis.exists(key);
        jedis.close();
        return exists;
    }

    @Override
    public Long del(String... keys) {
        Jedis jedis = jedisPool.getResource();
        Long del = jedis.del(keys);
        return del;
    }

    @Override
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long del = jedis.del(key);
        jedis.close();
        return del;
    }

    @Override
    public Long hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        Long hset = jedis.hset(key, field, value);
        jedis.close();
        return hset;
    }

    @Override
    public String hget(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.hget(key, field);
        jedis.close();
        return result;
    }

    @Override
    public Long hdel(String key, String... fields) {
        Jedis jedis = jedisPool.getResource();
        Long hdel = jedis.hdel(key, fields);
        jedis.close();
        return hdel;
    }

    @Override
    public Long hlen(String key) {
        Jedis jedis = jedisPool.getResource();
        Long hlen = jedis.hlen(key);
        jedis.close();
        return hlen;
    }

    @Override
    public Long expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        Long expire = jedis.expire(key, seconds);
        return expire;
    }
}
