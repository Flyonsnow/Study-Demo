package com.wenxuezheng.study.spring.event;


import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author    
 * @date 2021/10/10 10:41 下午
 */
@Component
public class CustomEvent {

    private String name = "test";

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CustomEvent{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
