package com.wenxuezheng.study.stream.controller;


import com.wenxuezheng.study.stream.mq.Stream2Producer;
import com.wenxuezheng.study.stream.mq.StreamProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hu.bo@cestc.cn
 * @date 2021/10/19 1:50 下午
 */
@Slf4j
@RestController
@RequestMapping("/test")
@EnableBinding(value = {StreamProducer.class, Stream2Producer.class})
public class TestController {

    @Autowired
    StreamProducer streamProducer;
    @Autowired
    Stream2Producer stream2Producer;

    @PostMapping("/send")
    public void send(String str) {
        log.info("sendMessage, messageSendDto:{}", str);
        //String payload = JSON.toJSONString(messageSendDto);
        Map<String, Object> headers = new HashMap<>(1);
        //headers.put(MessageConst.PROPERTY_TAGS, "testTag");
        MessageHeaders messageHeaders = new MessageHeaders(headers);
        Message<String> message = MessageBuilder.createMessage(str, messageHeaders);
        streamProducer.output().send(message);
        stream2Producer.output2().send(message);
    }


}
