package com.wenxuezheng.design.pattern.singleton.lazy_initialization;


/**
 * TODO
 *
 * @author    
 * @date 2021/7/1 5:39 下午
 */
public class DoubleCheckLazySingleton {
    private static DoubleCheckLazySingleton instance;

    private DoubleCheckLazySingleton() {
    }

    public static DoubleCheckLazySingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLazySingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }
}
