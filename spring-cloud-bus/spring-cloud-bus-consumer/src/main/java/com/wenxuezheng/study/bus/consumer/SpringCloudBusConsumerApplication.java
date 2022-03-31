package com.wenxuezheng.study.bus.consumer;

import com.wenxuezheng.study.bus.consumer.message.UserMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(UserMessage.class)
@SpringBootApplication
public class SpringCloudBusConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBusConsumerApplication.class, args);
    }

}
