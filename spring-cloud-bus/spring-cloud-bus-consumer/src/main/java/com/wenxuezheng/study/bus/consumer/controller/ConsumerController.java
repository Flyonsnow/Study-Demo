package com.wenxuezheng.study.bus.consumer.controller;

import com.wenxuezheng.study.bus.consumer.message.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hu.bo@cestc.cn
 * @date 2022/3/31 2:29 PM
 */
@RestController
public class ConsumerController {
    //装配接口通道
    @Autowired
    private UserMessage userMessage;


    @GetMapping("/send/name")
    public boolean sendUserMessage(@RequestParam("name") String name) {
        //获取通道
        MessageChannel messageChannel = userMessage.output();
        //格式化消息
        GenericMessage<String> message = new GenericMessage<String>(name);
        System.out.println("begin to send ......" + name);
        //发送
        return messageChannel.send(message);
    }
}
