package com.example.nacos.config.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


/**
 * TODO
 *
 * @author  
 * @since 2019-01-17
 */
@Slf4j
@RefreshScope
@Data
@Component
public class NacosConfig {

    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private Integer age;
    @Value("${user.phone}")
    private String phone;
}
