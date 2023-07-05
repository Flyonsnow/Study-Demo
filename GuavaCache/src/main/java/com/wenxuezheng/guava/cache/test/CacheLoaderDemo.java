package com.wenxuezheng.guava.cache.test;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

/**
 * @author    
 * @date 2022/3/24 2:20 PM
 */
public class CacheLoaderDemo {


    public static void main(String[] args) throws ExecutionException {
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
                //.maximumSize()
                //.expireAfterWrite()
                //.recordStats()
                //.removalListener()
                .build(new CacheLoader<String, Object>() {
                    //读取数据源
                    @Override
                    public Object load(String s) throws Exception {
                        return Constant.dataSourceMap.get(s);
                    }
                });

        initCache(cache);
        System.out.println("cache size:" + cache.size());
        displayCache(cache);

    }

    public static void displayCache(LoadingCache<String, Object> cache) {
        cache.asMap().forEach((k, v) -> {
            System.out.printf("k:%s,v:%s\n", k, v);
        });
    }


    /**
     * 初始化缓存
     */
    public static void initCache(LoadingCache<String, Object> cache) throws ExecutionException {
        for (int i = 1; i <= 3; i++) {
            cache.get(String.valueOf(i));
        }
    }
}
