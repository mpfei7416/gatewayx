package com.lmpdyy.gatewayx.common.config;

/**
 * @InterfaceName ServiceInvoker
 * @description:  服务调用的接口模型描述
 * @author: nxlea
 * @create: 2023-09-15 09:43
 **/
public interface ServiceInvoker {

    /**
     *  获取真正的服务调用的全路径
     */
    String getInvokerPath();

    void setInvokerPath(String invokerPath);

    // 获取指定服务调用绑定的唯一规则id
    String getRuleId();

    void setRuleId(String ruleId);

    int  getTimeout();

    void setTimeout(int timeout);
}
