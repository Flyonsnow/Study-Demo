package com.wenxuezheng.design.pattern.singleton.container;


import java.util.HashMap;
import java.util.Map;

/**
 * 容器式单例
 *
 * @author hu.bo@cestc.cn
 * @date 2021/7/1 5:42 下午
 */
public class ContainerSingleton {
    private static Map<String, Object> objMap = new HashMap<String, Object>();

    private ContainerSingleton() {
    }

    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getInstance(String key) {
        return objMap.get(key);
    }
}
