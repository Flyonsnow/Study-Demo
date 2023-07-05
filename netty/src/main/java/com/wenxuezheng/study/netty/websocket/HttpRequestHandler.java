package com.wenxuezheng.study.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.extern.slf4j.Slf4j;


/**
 * @author    
 * @date 2022/7/26 17:18
 */
@Slf4j
public class HttpRequestHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String token;
        if (null != msg && msg instanceof FullHttpRequest) {
            log.info("准备提取token");
            //转化为http请求
            FullHttpRequest request = (FullHttpRequest) msg;
            //拿到请求地址
            String uri = request.uri();
            //判断是不是websocket请求，如果是拿出我们传递的参数（我的是token）
            String origin = request.headers().get("Origin");
            if (null == origin) {
                ctx.close();
            } else {
                if (null != uri && uri.contains("/ws") && uri.contains("?")) {
                    String[] uriArray = uri.split("\\?");
                    if (null != uriArray && uriArray.length > 1) {
                        String[] paramsArray = uriArray[1].split("=");
                        if (null != paramsArray && paramsArray.length > 1) {
                            token = paramsArray[1];
                            log.info("提取token成功:{}", token);
                        }
                    }
                    //重新设置请求地址
                    request.setUri("/ws");
                }
            }
        }
        //接着建立请求
        super.channelRead(ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        log.info("error:{}", cause.getCause(), cause);
    }
}
