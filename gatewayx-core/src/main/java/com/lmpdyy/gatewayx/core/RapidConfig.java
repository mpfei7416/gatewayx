package com.lmpdyy.gatewayx.core;

import com.lmax.disruptor.*;
import com.lmpdyy.gatewayx.common.constants.BasicConst;
import com.lmpdyy.gatewayx.common.constants.RapidBufferHelper;
import com.lmpdyy.gatewayx.common.util.NetUtils;
import lombok.Data;

/**
 * @ClassName RapidConfig
 * @description: 网关通用配置信息类
 * @author: nxlea
 * @create: 2023-08-23 10:09
 */
@Data
public class RapidConfig {


    /**
     * 默认端口
     */
    private int port = 8888;

    /**
     * 网关服务唯一ID
     */
    private String rapidId = NetUtils.getLocalIp() + BasicConst.COLON_SEPARATOR +  port;

    /**
     * 网关的注册中心地址
     */
    private String registerAddress = "http://192.168.11.114:2379,http://192.168.11.115:2379,http://192.168.11.116:2379";  // 替换为网关注册中心地址

    /**
     * 网关的命名空间
     */
    private String nameSpace = "rapid-dev";

    /**
     * 网关服务器的cpu核心映射的线程数
     */
    private int processThread = Runtime.getRuntime().availableProcessors();

    /**
     * netty boss线程数
     */
    private int eventLoopGroupBossNum = 1;

    /**
     * netty work线程数
     */
    private int eventLoopGroupWorkNum = processThread;

    /**
     * Epoll 是否开启
     */
    private boolean useEPollo = true;

    /**
     * 是否开启内存分配机制
     */
    private boolean nettyAllocator = true;

    /**
     * http body报文的最大长度
     */
    private int maxContentLength = 1024 * 1024 * 64;

    /**
     * httpAsync 参数选项
     */

    /**
     * dubbo 开启连接数的定义
     */
    private int dubboConnections = processThread;

    /**
     *  completableFuture 回调处理结果
     *      whenComplete    or
     *      whenCompleteAsync
     *      whenComplete 默认单异步模式， 如果为false ，则为双异步模式
     */
    private boolean whenComplete = true;


    // 网关队列配置
    /**
     * 网关队列缓冲模式， Flusher or MPMC 模式
     */
    private String bufferType = RapidBufferHelper.MPMC;

    /**
     *  内存队列大小
     */
    private int bufferSize = 1024 * 16;

    /**
     * 网关队列，阻塞、等待策略 ， spin、yield（线程让步）
     */
    private String waitStrategy = "blocking";



    // TODO
    // http请求 配置
    /**
     * 默认请求超时时间
     */
    private long requestTimeout = 3000;

    /**
     * 默认路由转发的慢调用时间 2s
     */
    private long routeTimeout = 2000;

    /**
     *  kafka 地址
     */
    private String kafkaAddress = "";

    /**
     * 网关服务指标消息主题
     */
    private String metricTopic ="rapid-metric-topic";

    public WaitStrategy getATureWaitStrategy() {
        switch (waitStrategy) {
            case "busySpin":
                return new BusySpinWaitStrategy();
            case "yielding":
                return new YieldingWaitStrategy();
            case "sleeping":
                return new SleepingWaitStrategy();
            default:
                return new BlockingWaitStrategy();
        }
    }


    // http Async参数选项
    /**
     * 连接超时时间
     */
    private int httpConnectionTimeOut = 30 * 1000;

    /**
     * 请求超时时间
     */
    private int httpRequestTimeout = 30 * 1000;

    /**
     * 客户端请求重试次数
     */
    private int httpMaxRequestRetry = 2;

    /**
     * 客户端请求的最大连接数
     */
    private int httpMaxConnections = 10000;

    /**
     * 客户端每个地址支持的最大连接数
     */
    private int httpConnectionsPerHost = 8000;

    /**
     *  客户端空闲连接超时时间， 默认为60s
     */
    private int httpPoolConnectionIdleTimeout = 60 * 1000;






}


