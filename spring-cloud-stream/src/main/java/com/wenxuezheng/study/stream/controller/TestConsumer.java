package com.wenxuezheng.study.stream.controller;

import com.wenxuezheng.study.stream.mq.Stream2Consumer;
import com.wenxuezheng.study.stream.mq.StreamConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;


/**
 * @author hu.bo@cestc.cn
 * @date 2021/10/19 2:01 下午
 */
@Slf4j
@EnableBinding(value = {StreamConsumer.class, Stream2Consumer.class})
public class TestConsumer {
    @StreamListener("input")
    public void inputConsumer(String message) {
        System.out.println("consumer:" + message);
    }

    @StreamListener("s-input")
    public void inputConsumers(String message) {
        System.out.println("s-consumer:" + message);
    }
}
