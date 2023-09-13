package com.lmpdyy.gatewayx.core.netty.processor;

import com.lmpdyy.gatewayx.core.context.HttpRequestWrapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName NettyMpmcProcessor
 * @description: mpmc的核心实现处理器, 最终我们还是要使用NettyCoreProcessor
 * @author: nxlea
 * @create: 2023-09-13 10:37
 */
@Slf4j
public class NettyMpmcProcessor implements NettyProcessor{



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
