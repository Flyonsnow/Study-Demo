package com.wenxuezheng.design.pattern.factory.factory_method;

import com.wenxuezheng.design.pattern.factory.simple_factory.BmwCar;
import com.wenxuezheng.design.pattern.factory.simple_factory.ICar;

/**
 * TODO
 *
 * @author    
 * @date 2021/7/1 1:33 下午
 */
public class BmwCarFactory implements ICarFactory {

    @Override
    public ICar getCar() {
        return new BmwCar();
    }
}
