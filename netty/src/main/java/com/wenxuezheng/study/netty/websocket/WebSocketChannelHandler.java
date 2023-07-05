package com.wenxuezheng.study.netty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * @author    
 * @date 2022/7/26 14:42
 */
@Slf4j
@RequiredArgsConstructor
public class WebSocketChannelHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private final ChannelGroup group;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String str = msg.text();
        // userid, to , message
        String[] split = str.split(",");
        String userId = split[0];
        String to = split[1];
        String message = split[2];


        Channel channel = ctx.channel();
        Attribute<String> attr = channel.attr(AttributeKey.valueOf("userId"));
        channel.attr(AttributeKey.valueOf("to")).set(to);
        attr.setIfAbsent(userId);
        ctx.writeAndFlush(new TextWebSocketFrame("resp:" + message));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        group.add(ctx.channel());
    }
}
