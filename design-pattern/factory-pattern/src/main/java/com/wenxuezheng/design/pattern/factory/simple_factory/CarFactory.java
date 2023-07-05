package com.wenxuezheng.design.pattern.factory.simple_factory;


/**
 * TODO
 *
 * @author    
 * @date 2021/7/1 1:17 下午
 */
public class CarFactory {

    public ICar getCar(String name) {
        if ("Benz".equals(name)) {
            return new BenzCar();
        }
        if ("Bmw".equals(name)) {
            return new BmwCar();
        }
        throw new IllegalArgumentException();
    }
}
