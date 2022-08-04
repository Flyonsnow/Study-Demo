package com.wenxuezheng.study.netty.echo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;


/**
 * @author hu.bo
 * @date 2022/7/19 00:01
 */
@Slf4j
public class EchoServer {
    int port = 8080;

    public static void main(String[] args) throws Exception {
        new EchoServer().start();
    }

    public void start() throws Exception {
        EchoServerHandler echoServerHandler = new EchoServerHandler();
        //创建EventLoopGroup
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        //创建ServerBootstrap
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(eventLoopGroup)
                // 指定所使用的NIO传输Channel
                .channel(NioServerSocketChannel.class)
                // 使用指定的端口设置socket地址
                .localAddress(new InetSocketAddress(port))
                // 添加一个EchoServerHandler到子Channel的ChannelPipLine
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(echoServerHandler);
                    }
                });
        //异步地绑定服务器；,调用 sync()方法阻塞, 等待直到绑定完成
        ChannelFuture channelFuture = serverBootstrap.bind().sync();
        //获取 Channel 的CloseFuture， 并且阻塞当前线程直到它完成
        channelFuture.channel().closeFuture().sync();
        //关闭 EventLoopGroup， 释放所有的资源
        eventLoopGroup.shutdownGracefully().sync();


    }

}
