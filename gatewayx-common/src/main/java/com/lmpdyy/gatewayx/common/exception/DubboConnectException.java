package com.lmpdyy.gatewayx.common.exception;

import com.lmpdyy.gatewayx.common.enums.ResponseCode;
import lombok.Getter;

/**
 * @ClassName DubboConnectException
 * @description:
 * @author: nxlea
 * @create: 2023-09-13 15:52
 */
public class DubboConnectException extends RapidConnectException{


    private static final long serialVersionUID = 1974481587470857585L;

    @Getter
    private final String interfaceName;

    @Getter
    private final String methodName;


    public DubboConnectException(String uniqueId, String requestUrl, String interfaceName, String methodName) {
        super(uniqueId, requestUrl);
        this.interfaceName = interfaceName;
        this.methodName = methodName;
    }

    public DubboConnectException(Throwable cause, String uniqueId, String requestUrl, ResponseCode code, String interfaceName, String methodName) {
        super(cause, uniqueId, requestUrl, code);
        this.interfaceName = interfaceName;
        this.methodName = methodName;
    }
}
