package com.example.nacos.config.controller;

import com.example.nacos.config.config.NacosConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * TestController
 *
 * @author  
 * @since 2019-01-16
 */
@Slf4j
//@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController {

    @Value(value = "${user.name}")
    String name;
    @Value("${user.age:18}")
    private Integer age;
    @Value("${user.phone:${user.default-phone:10000}}")
    private String phone;

    @Autowired
    private NacosConfig nacosConfig;

    @GetMapping("/user")
    public String user() {
        return String.format("user.name:%s,user.age:%d,user.phone:%s", this.name, age, phone);
    }

    @GetMapping("/getConfig")
    public String getConfig() {
        return String.format("user.name:%s,user.age:%d,user.phone:%s", nacosConfig.getName(), nacosConfig.getAge(), nacosConfig.getPhone());
    }


}
