package com.example.nacos.dubbo.provider.nacos.config.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * TestController
 *
 * @author hubo
 * @since 2019-01-16
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/testScope")
public class TestRefreshScopeController {

    @Autowired
    private TestRefreshScopeController testController;

    @Value(value = "${name}")
    String name;
    private Integer age;
    private String phone;

    @GetMapping("/user")
    private String user() {
        System.out.println("name : " + name);
        return String.format("user.name:%s,user.age:%d,user.phone:%s", this.name, age, phone);
    }

    @GetMapping("/di")
    private String di() {
        System.out.println("testController : " + testController);
        return "testController:" + testController;
    }
}
