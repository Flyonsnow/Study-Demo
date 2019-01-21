package com.example.nacos.dubbo.consumer;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class NacosDubboConsumerExampleApplication {

    public static void main(String[] args) {
        //SpringApplication.run(NacosDubboProviderExampleApplication.class, args);
        new SpringApplicationBuilder(NacosDubboConsumerExampleApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}

