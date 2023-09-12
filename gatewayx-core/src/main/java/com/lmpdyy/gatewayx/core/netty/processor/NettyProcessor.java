package com.lmpdyy.gatewayx.core.netty.processor;

import com.lmpdyy.gatewayx.core.LifeCycle;
import com.lmpdyy.gatewayx.core.context.HttpRequestWrapper;
import org.apache.dubbo.rpc.filter.EchoFilter;

/**
 * @ClassName NettyProcessor
 * @description: 处理Netty核心逻辑的执行器接口定义
 * @author: nxlea
 * @create: 2023-09-12 15:11
 */
public interface NettyProcessor {

    void process(HttpRequestWrapper httpRequestWrapper) throws Exception;

    void start();


    void shutdown();
}
