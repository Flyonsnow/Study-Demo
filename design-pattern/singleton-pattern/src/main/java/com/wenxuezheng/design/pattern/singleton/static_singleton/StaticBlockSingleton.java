package com.wenxuezheng.design.pattern.singleton.static_singleton;


/**
 * TODO
 *
 * @author hu.bo@cestc.cn
 * @date 2021/7/1 5:30 下午
 */
public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
