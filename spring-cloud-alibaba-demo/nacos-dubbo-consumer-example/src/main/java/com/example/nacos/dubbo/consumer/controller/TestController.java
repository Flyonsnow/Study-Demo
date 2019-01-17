package com.example.nacos.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.nacos.dubbo.common.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * TODO
 *
 * @author hubo
 * @since 2019-01-16
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private ExampleService exampleService;


    @GetMapping("/sayHello")
    public String sayHello(String message) {
        final String s = exampleService.sayHello(message);
        return s;
    }


}
