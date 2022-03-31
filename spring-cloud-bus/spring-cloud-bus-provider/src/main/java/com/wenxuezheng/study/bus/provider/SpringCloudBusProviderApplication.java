package com.wenxuezheng.study.bus.provider;

import com.wenxuezheng.study.bus.provider.listener.UserMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(UserMessage.class)
@SpringBootApplication
public class SpringCloudBusProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBusProviderApplication.class, args);
    }

}
