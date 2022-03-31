package com.wenxuezheng.study.bus.provider.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author hu.bo@cestc.cn
 * @date 2022/3/31 10:56 AM
 */

public interface UserMessage {
    String INPUT = "input";
    String test = "springCloudBusTest";

    //定义输出源
    // 这里就是Spring Cloud Stream提供的输入通道
    @Input(INPUT)
    SubscribableChannel input();

    //
    //@Input(test)
    //SubscribableChannel input2();



}
