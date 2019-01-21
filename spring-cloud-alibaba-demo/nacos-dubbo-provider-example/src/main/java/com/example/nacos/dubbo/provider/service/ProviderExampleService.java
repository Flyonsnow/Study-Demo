package com.example.nacos.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.nacos.dubbo.common.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;


/**
 * ProviderExampleService
 *
 * @author hubo
 * @since 2019-01-16
 */
@Slf4j
@Service(
        version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
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
