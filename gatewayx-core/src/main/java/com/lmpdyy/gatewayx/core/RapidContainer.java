package com.lmpdyy.gatewayx.core;

import com.lmpdyy.gatewayx.core.netty.NettyHttpClient;
import com.lmpdyy.gatewayx.core.netty.NettyHttpServer;
import com.lmpdyy.gatewayx.core.netty.processor.NettyProcessor;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RapidContainer
 * @description: 主流程的容器类
 * @author: nxlea
 * @create: 2023-09-12 15:05
 */

@Slf4j
public class RapidContainer implements LifeCycle {
    // 核心配置类
    private final RapidConfig rapidConfig;

    // 接收http请求的server
    private NettyHttpServer nettyHttpServer;

    // http 转发的核心类
    private NettyHttpClient nettyHttpClient;

    // 核心处理器
    private NettyProcessor nettyProcessor;

    public RapidContainer(RapidConfig rapidConfig) {
        this.rapidConfig = rapidConfig;
        init();
    }


    @Override
    public void init() {
        // 1、构建核心处理器

        // 2、是否开启缓存

        // 3、 创建NettyHttpServer

        // 4、创建NettyHttpClient

    }

    @Override
    public void start() {
        nettyProcessor.start();
        nettyHttpServer.start();
        nettyHttpClient.start();
    }

    @Override
    public void shutdown() {
        nettyProcessor.shutdown();
        nettyHttpServer.shutdown();
        nettyHttpClient.shutdown();
    }
}
