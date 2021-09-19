package com.wenxuezheng.design.pattern.factory.simple_factory;


/**
 * TODO
 *
 * @author hu.bo@cestc.cn
 * @date 2021/7/1 1:20 下午
 */
public class Client {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        ICar bmw = carFactory.getCar("Bmw");
        ICar benz = carFactory.getCar("Benz");
    }
}
