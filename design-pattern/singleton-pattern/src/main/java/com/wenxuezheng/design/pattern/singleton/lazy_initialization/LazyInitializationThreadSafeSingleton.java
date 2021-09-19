package com.wenxuezheng.design.pattern.singleton.lazy_initialization;


/**
 * TODO
 *
 * @author hu.bo@cestc.cn
 * @date 2021/7/1 5:34 下午
 */
public class LazyInitializationThreadSafeSingleton {
    private static LazyInitializationThreadSafeSingleton instance;

    private LazyInitializationThreadSafeSingleton() {
    }

    public static synchronized LazyInitializationThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationThreadSafeSingleton();
        }
        return instance;
    }
}
