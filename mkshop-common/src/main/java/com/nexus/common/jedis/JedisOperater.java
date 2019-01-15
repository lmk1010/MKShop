package com.nexus.common.jedis;

public interface JedisOperater{


    public String set(String key, String value);

    public String get(String key);

    public Boolean exists(String key);

    public Long del(String... keys);

    public Long del(String key);

    public Long hset(String key, String field, String value);

    public String hget(String key, String field);

    public Long hdel(String key, String... fields);

    public Long hlen(String key);

    public Long expire(String key, int seconds);



}
