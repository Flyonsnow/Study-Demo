package com.wenxuezheng.study.bus.provider.listener;


import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author hu.bo@cestc.cn
 * @date 2022/3/31 10:12 AM
 */
@Component
public class UserMessageListener {
    //Spring Cloud Stream 提供的监听接口
    //监听定义好的输出通道
    @StreamListener(UserMessage.INPUT)
    public void streamListenerOnMessage(String name) {
        System.out.println("Stream on  @StreamListener");
        System.out.println(name);

    }



    //@Bean
    //Consumer<String> input(){
    //    return str -> {
    //        System.out.println("Stream on  @StreamListener");
    //        System.out.println(str);
    //    };
    //}


}
