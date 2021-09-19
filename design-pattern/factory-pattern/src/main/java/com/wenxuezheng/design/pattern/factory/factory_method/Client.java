package com.wenxuezheng.design.pattern.factory.factory_method;


import com.wenxuezheng.design.pattern.factory.simple_factory.ICar;

/**
 * TODO
 *
 * @author hu.bo@cestc.cn
 * @date 2021/7/1 1:20 下午
 */
public class Client {

    public static void main(String[] args) {
        ICarFactory benzCarFactory = new BenzCarFactory();
        ICar benz = benzCarFactory.getCar();
        ICarFactory bmwCarFactory = new BmwCarFactory();
        ICar bmw = bmwCarFactory.getCar();
    }
}
