package com.wenxuezheng.design.pattern.singleton.eager_initialization;


/**
 * 饿汉式
 *
 * @author    
 * @date 2021/7/1 5:14 下午
 */
public class EagerInitializationSingleton {
    private static final EagerInitializationSingleton instance = new EagerInitializationSingleton();

    //private constructor to avoid client applications to use constructor
    private EagerInitializationSingleton(){}

    public static EagerInitializationSingleton getInstance(){
        return instance;
    }
}
