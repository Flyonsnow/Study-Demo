package com.wenxuezheng.design.pattern.singleton.lazy_initialization;


/**
 * TODO
 *
 * @author hu.bo@cestc.cn
 * @date 2021/7/1 5:34 下午
 */
public class LazyInitializationSingleton {
    private static LazyInitializationSingleton instance;

    private LazyInitializationSingleton() {
    }

    public static LazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }
}
