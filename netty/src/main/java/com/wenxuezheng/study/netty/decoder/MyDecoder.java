package com.wenxuezheng.study.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * @author    
 * @date 2022/7/25 17:48
 */
@Slf4j
public class MyDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        log.info("MyDecoder...");
        // 每读取到4个字节，解码为一个int
        if (byteBuf.readableBytes() >= 4) {
            // 添加到解码消息的List中
            list.add(byteBuf.readInt());
        }

    }
}
