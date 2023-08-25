package com.lmpdyy.gatewayx.core;

/**
 * @ClassName LifeCycle
 * @description: 生命周期管理接口
 * @author: nxlea
 * @create: 2023-08-24 15:14
 */
public interface LifeCycle {
    /**
     * 生命周期组件的初始化方法
     */
    void init();

    /**
     * 生命周期组件的启动方法
     */
    void start();

    /**
     * 生命周期组件的销毁方法
     */
    void deploy();

}
