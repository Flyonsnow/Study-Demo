package com.wenxuezheng.study.monitor.controller;

import com.wenxuezheng.study.monitor.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hu.bo@cestc.cn
 * @date 2022/4/7 10:31 AM
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/post")
    public void test(String str){
        testService.test(str);
    }

    @PostMapping("/error")
    public void error(String str){
        System.out.println(0/0);
    }
}
