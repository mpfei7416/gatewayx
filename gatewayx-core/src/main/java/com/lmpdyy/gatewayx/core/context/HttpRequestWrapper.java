package com.lmpdyy.gatewayx.core.context;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName HttpRequestWapper
 * @description: 请求包装类
 * @author: nxlea
 * @create: 2023-09-12 15:22
 */
@Slf4j
public class HttpRequestWrapper {

    private FullHttpRequest fullHttpRequest;

    private ChannelHandlerContext ctx;


}
