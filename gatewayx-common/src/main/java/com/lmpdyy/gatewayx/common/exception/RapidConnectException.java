package com.lmpdyy.gatewayx.common.exception;

import com.lmpdyy.gatewayx.common.enums.ResponseCode;
import lombok.Getter;

/**
 * @ClassName RapidConnectException
 * @description: 连接异常定义类
 * @author: nxlea
 * @create: 2023-09-13 15:45
 */
public class RapidConnectException extends RapidBaseException{

    private static final long serialVersionUID = 8353221060276669359L;

    @Getter
    private final String uniqueId;

    @Getter
    private final String requestUrl;

    public RapidConnectException(String uniqueId, String requestUrl) {
        this.uniqueId = uniqueId;
        this.requestUrl = requestUrl;
    }

    public RapidConnectException(Throwable cause, String uniqueId, String requestUrl, ResponseCode code) {
        super(code.getMessage(), cause, code);
        this.uniqueId = uniqueId;
        this.requestUrl = requestUrl;
    }
}
