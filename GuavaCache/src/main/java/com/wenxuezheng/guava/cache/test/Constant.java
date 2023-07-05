package com.wenxuezheng.guava.cache.test;

import com.google.common.collect.Maps;

import java.util.Map;


/**
 * @author    
 * @date 2022/3/24 2:43 PM
 */
public class Constant {
    public static Map<String, String> dataSourceMap;

    static {
        dataSourceMap = Maps.newHashMap();
        dataSourceMap.put("1", "张飞");
        dataSourceMap.put("2", "赵云");
        dataSourceMap.put("3", "马超");
        dataSourceMap.put("4", "关羽");
        dataSourceMap.put("5", "黄忠");
    }
}
