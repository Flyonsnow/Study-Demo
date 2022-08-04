package com.wenxuezheng.study.netty.decoder;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;


/**
 * @author hu.bo
 * @date 2022/7/25 17:38
 */
@Slf4j
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //设置log监听器，并且日志级别为debug，方便观察运行流程
        if(log.isDebugEnabled()){
            pipeline.addLast("logging",new LoggingHandler("DEBUG"));
        }

        pipeline.addLast(new MyDecoder());






    }
}
