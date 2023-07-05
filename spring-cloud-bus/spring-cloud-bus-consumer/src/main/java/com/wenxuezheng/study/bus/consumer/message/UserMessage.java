package com.wenxuezheng.study.bus.consumer.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author    
 * @date 2022/3/31 2:30 PM
 */

public interface UserMessage {

    String OUTPUT = "output";
    //定义输入源
    @Output(OUTPUT)
    MessageChannel output();
}
