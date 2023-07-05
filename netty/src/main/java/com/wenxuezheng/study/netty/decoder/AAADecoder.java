package com.wenxuezheng.study.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LineBasedFrameDecoder;
import lombok.extern.slf4j.Slf4j;


/**
 * @author hu.bo
 * @date 2022/7/25 18:32
 */
@Slf4j
public class AAADecoder extends LineBasedFrameDecoder {

    public AAADecoder(int maxLength) {
        super(maxLength);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
        System.out.println("AAADecoder");
        return super.decode(ctx, buffer);
    }
}
