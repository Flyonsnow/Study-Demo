package com.wenxuezheng.service.impl;

import com.wenxuezheng.service.MessageService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


/**
 * @author    
 * 2022/9/29 20:41
 */
public class MessageServiceImpl implements MessageService, BeanFactoryPostProcessor {

    @Override
    public String getMessage() {
        return "Hello World";
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MessageServiceImpl post process..");
    }
}
