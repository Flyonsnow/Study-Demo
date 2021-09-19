package com.wenxuezheng.design.pattern.singleton.static_singleton;


/**
 * TODO
 *
 * @author hu.bo@cestc.cn
 * @date 2021/7/1 5:30 下午
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton() {
    }

    //static block initialization for exception handling
    private static class Singleton {
        private static final StaticInnerSingleton S_INSTANCE = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return Singleton.S_INSTANCE;
    }
}
