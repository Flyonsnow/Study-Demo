package com.wenxuezheng.study.monitor.service;


import com.wenxuezheng.study.monitor.annotation.MonitoredService;
import org.springframework.stereotype.Service;

/**
 * @author hu.bo@cestc.cn
 * @date 2022/4/7 10:15 AM
 */
@Service
@MonitoredService
public class TestService {


    public void test(String str) {
        System.out.println("str :" + str);
    }
}
