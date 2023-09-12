package com.lmpdyy.gatewayx.common.enums;

/**
 * @ClassName LoadBalanceStrategy
 * @description:
 * @author: nxlea
 * @create: 2023-09-05 10:45
 */
public enum LoadBalanceStrategy {
    RANDOM("RANDOM", "随机负载均衡策略"),
    ROUND_ROBIN("ROUND_ROBIN", "轮训负载均衡策略");

    private String val;
    private String desc;

    LoadBalanceStrategy(String val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public String getVal() {
        return val;
    }

    public String getDesc() {
        return desc;
    }
}
