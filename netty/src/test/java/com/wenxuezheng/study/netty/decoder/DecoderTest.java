package com.wenxuezheng.study.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author    
 * @date 2022/7/25 17:55
 */
@Slf4j
public class DecoderTest {

    @Test
    public void test() {
        ByteBuf byteBuf = Unpooled.buffer();
        for (int i = 0; i < 10; i++) {
            byteBuf.writeByte(i);
        }
        ByteBuf input = byteBuf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(
                new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new MyDecoder())
                                .addLast(new AAADecoder(10))
                                .addLast(new MyDecoder2());

                    }
                });
        assertTrue(channel.writeInbound(input.retain()));

        assertTrue(channel.finish());

        Integer read = channel.readInbound();

        System.out.println(read);


    }
}
