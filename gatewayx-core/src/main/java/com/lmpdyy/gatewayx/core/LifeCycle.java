package com.lmpdyy.gatewayx.core;

/**
 * @InterfaceName LifeCycle
 * @description: 生命周期管理接口
 * @author: nxlea
 * @create: 2023-09-05 10:54
 **/
public interface LifeCycle {
    /**
     * 生命周期接口初始化方法
     */
    void init();

    /**
     * 生命周期接口启动方法
     */
    void start();


    /**
     * 生命周期接口关系方法
     */
    void shutdown();




}
