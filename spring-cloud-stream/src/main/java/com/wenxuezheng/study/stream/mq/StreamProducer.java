package com.wenxuezheng.study.stream.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


/**
 * @author hu.bo@cestc.cn
 * @date 2021/10/19 1:48 下午
 */
public interface StreamProducer {

    @Output("output")
    MessageChannel output();

}