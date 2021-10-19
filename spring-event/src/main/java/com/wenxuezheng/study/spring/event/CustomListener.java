package com.wenxuezheng.study.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author hu.bo@cestc.cn
 * @date 2021/10/10 10:41 下午
 */
@Component
public class CustomListener {

    @EventListener
    public void event(CustomEvent event) {
        System.out.println("----------------------");
        System.out.println(event);
    }
}
