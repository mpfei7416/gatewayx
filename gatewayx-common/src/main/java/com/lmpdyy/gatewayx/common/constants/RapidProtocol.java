package com.lmpdyy.gatewayx.common.constants;

/**
 * @InterfaceName RapidProtocol
 * @description:
 * @author: nxlea
 * @create: 2023-09-13 15:41
 **/
public interface RapidProtocol {
    String HTTP = "http";
    String DUBBO = "dubbo";

    static boolean isHttp(String protocol) {
        return HTTP.equals(protocol);
    }

    static boolean isDubbo(String protocol) {
        return DUBBO.equals(protocol);
    }
}
