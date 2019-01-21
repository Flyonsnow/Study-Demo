package com.example.nacos.dubbo.provider;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class NacosDubboProviderExampleApplication {

    public static void main(String[] args) {
        //SpringApplication.run(NacosDubboProviderExampleExampleApplication.class, args);
        new SpringApplicationBuilder(NacosDubboProviderExampleApplication.class)
                //.web(WebApplicationType.SERVLET)
                .web(WebApplicationType.NONE)
                .run(args);
    }

}

