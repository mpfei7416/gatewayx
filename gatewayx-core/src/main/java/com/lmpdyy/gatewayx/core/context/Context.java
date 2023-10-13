package com.lmpdyy.gatewayx.core.context;

/**
 * @InterfaceName Context
 * @description: 网关上下文接口定义
 * @author: nxlea
 * @create: 2023-10-13 15:07
 **/
public interface Context {

    // 一个请求正在执行过程中
    int RUNNING = -1;

    // 写回响应标记， 标记当前Context / 请求需要写回
    int WRITTEN = 0;

    // 当回写成功后， 设置该标记， ctx.writeAndFlush(response)
    int COMPLETED = 1;

    // 表示整个网关请求完成，处理完毕
    int TERMINATED = 2;


    /**
     * 设置上下文状态为正常运行状态
     */
    void runned();

    /**
     * 设置上下文状态为标记写回
     */
    void writtened();
}
