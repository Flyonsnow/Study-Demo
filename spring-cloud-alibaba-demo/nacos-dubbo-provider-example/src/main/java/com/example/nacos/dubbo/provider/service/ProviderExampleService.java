package com.example.nacos.dubbo.provider.service;

import com.example.nacos.dubbo.common.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;


/**
 * ProviderExampleService
 *
 * @author hubo
 * @since 2019-01-16
 */
@Slf4j
@DubboService(version = "${demo.service.version}")
public class ProviderExampleService implements ExampleService {

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;


    @Override
    public String sayHello(String message) {
        return String.format("[%s] : Hello, %s", serviceName, message);
    }
}
