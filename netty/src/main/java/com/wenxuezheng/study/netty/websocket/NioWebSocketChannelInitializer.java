package com.wenxuezheng.study.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * @author hu.bo
 * @date 2022/7/22 18:10
 */
@Slf4j
@RequiredArgsConstructor
public class NioWebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {
    private final ChannelGroup group;

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        //设置log监听器，并且日志级别为debug，方便观察运行流程
        //if (log.isDebugEnabled()) {
        //    pipeline.addLast("logging", new LoggingHandler("DEBUG"));
        //}
        //设置解码器
        pipeline.addLast("http-codec", new HttpServerCodec());
        //聚合器，使用websocket会用到
        pipeline.addLast("aggregator", new HttpObjectAggregator(64 * 1024));
        //用于大数据的分区传输
        pipeline.addLast("http-chunked", new ChunkedWriteHandler());
        //自定义的业务handler
        pipeline.addLast("http-handler", new HttpRequestHandler());
        // 指定路由
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast("handler", new WebSocketChannelHandler(group));
    }


}