package com.wenxuezheng.study.netty.decoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;


/**
 * @author hu.bo
 * @date 2022/7/25 17:46
 */
@Slf4j
public class DecoderStart {


    public void start() {
        int bossGroupThreadNum = 1;
        int workGroupThreadNum = 4;

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup boosGroup = new NioEventLoopGroup(bossGroupThreadNum);
        EventLoopGroup workGroup = new NioEventLoopGroup(workGroupThreadNum);

        serverBootstrap.group(boosGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new MyChannelInitializer());
        //.childOption(ChannelOption.SO_KEEPALIVE, true);


    }
}
