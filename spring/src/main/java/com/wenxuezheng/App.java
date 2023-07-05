package com.wenxuezheng;

import com.wenxuezheng.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        MessageService messageService = context.getBean(MessageService.class);
        String message = messageService.getMessage();
        System.out.println(message);
    }
}
