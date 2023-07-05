package com.wenxuezheng.study.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.ImmediateEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @author    
 * @date 2022/7/22 17:11
 */
@Component
@Slf4j
public class WebsocketServerBootstrap {

    private final ChannelGroup channelGroup = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);

    public void start() {
        int bossGroupThreadNum = 1;
        int workGroupThreadNum = 4;
        int port = 8080;

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup boosGroup = new NioEventLoopGroup(bossGroupThreadNum);
        EventLoopGroup workGroup = new NioEventLoopGroup(workGroupThreadNum);

        serverBootstrap.group(boosGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new NioWebSocketChannelInitializer(channelGroup));
        //.childOption(ChannelOption.SO_KEEPALIVE, true);
        ChannelFuture future = serverBootstrap.bind(port);
        future.syncUninterruptibly();

        try {
            //获取 Channel 的CloseFuture， 并且阻塞当前线程直到它完成
            future.channel().closeFuture().sync();
            //关闭 EventLoopGroup， 释放所有的资源
            boosGroup.shutdownGracefully().sync();
            workGroup.shutdownGracefully().sync();
        } catch (InterruptedException e) {
            log.error("关闭异常, error:{}", e.getMessage(), e);
        } finally {
            channelGroup.close();
        }
    }

    public static void main(String[] args) {
        new WebsocketServerBootstrap().start();
    }


}
