package com.lmpdyy.gatewayx.common.constants;

/**
 * @InterfaceName RapidBufferHelper
 * @description: 网关缓冲辅助类
 * @author: nxlea
 * @create: 2023-08-23 10:43
 **/
public interface RapidBufferHelper {

    String FLUSHER = "FLUSHER";

    String MPMC = "MPMC";

    static boolean isMpmc(String bufferType) {
        return MPMC.equals(bufferType);
    }

    static boolean isFlusher(String bufferType) {
        return FLUSHER.equals(bufferType);
    }
}
