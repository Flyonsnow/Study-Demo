package com.example.nacos.dubbo.provider.nacos.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 注意spring cloud的版本要与spring boot版本匹配 spring-boot 2.1.x需要对应sc G版, 否则出现无法注册问题
 * <p>
 * 该example展示使用nacos-discovery进行注册的依赖
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryExampleApplication.class, args);
    }
}
