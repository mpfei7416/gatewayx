package com.lmpdyy.gatewayx.core.netty.processor;

import com.lmpdyy.gatewayx.core.RapidConfig;
import com.lmpdyy.gatewayx.core.context.HttpRequestWrapper;

/**
 * @ClassName NettyBatchEventProcessor
 * @description: flusher缓冲队列的核心实现, 最终调用的方法还是要回归到NettyCoreProcessor
 * @author: nxlea
 * @create: 2023-09-13 10:34
 */
public class NettyBatchEventProcessor implements NettyProcessor{

    private RapidConfig rapidConfig;

    private NettyCoreProcessor nettyCoreProcessor;

    public NettyBatchEventProcessor(RapidConfig rapidConfig, NettyCoreProcessor nettyCoreProcessor) {
        this.rapidConfig = rapidConfig;
        this.nettyCoreProcessor = nettyCoreProcessor;

        // todo
    }

    @Override
    public void process(HttpRequestWrapper httpRequestWrapper) throws Exception {

    }

    @Override
    public void start() {

    }

    @Override
    public void shutdown() {

    }
}
