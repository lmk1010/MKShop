package com.nexus.common.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TokenCache
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-14 20:18
 * @Version 1.0
 **/
public class TokenCache {

    public static final String TOKEN_PREFIX = "token_";

    private static LoadingCache<String,String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).
            expireAfterAccess(1, TimeUnit.MINUTES).build(new CacheLoader<String, String>() {
        //默认的数据加载器，如果get值时候没有命中缓存的key，则调用此方法
        @Override
        public String load(String s) throws Exception {
            return "null";
        }
    });

    public static void setKey(String key,String value){
        localCache.put(key,value);
    }

    public static String getKey(String key){
        String value = null;
        try{
            value = localCache.get(key);
            if ("null".equals(value)){
                return null;
            }
            return value;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void removeAll(){
        localCache.invalidateAll();
    }

    public static void remove(String key){
        localCache.invalidate(key);
    }


}
