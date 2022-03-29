package com.wenxuezheng.guava.cache.test;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author hu.bo@cestc.cn
 * @date 2022/3/24 2:20 PM
 */
public class CallBackDemo {


    public static void main(String[] args) throws ExecutionException {
        Cache<String, Object> cache = CacheBuilder.newBuilder()
                //.maximumSize()
                //.expireAfterWrite()
                //.recordStats()
                //.removalListener()
                .build();

        get("4", cache);
        System.out.println("cache size:" + cache.size());
        displayCache(cache);

    }

    public static void displayCache(Cache<String, Object> cache) {
        cache.asMap().forEach((k, v) -> {
            System.out.printf("k:%s,v:%s\n", k, v);
        });
    }


    public static void get(String key, Cache<String, Object> cache) throws ExecutionException {
        cache.get(key, new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                String s = Constant.dataSourceMap.get(key);
                cache.put(key, s);
                return s;
            }
        });
    }
}
