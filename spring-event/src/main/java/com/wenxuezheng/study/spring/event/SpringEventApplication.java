package com.wenxuezheng.study.spring.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringEventApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringEventApplication.class, args);

        context.publishEvent(new CustomEvent());
        context.close();
    }

}
