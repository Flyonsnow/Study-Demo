package com.wenxuezheng.study.stream.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;


/**
 * @author    
 * @date 2021/10/19 1:48 下午
 */
public interface StreamConsumer {

    @Input("input")
    MessageChannel input();
}
