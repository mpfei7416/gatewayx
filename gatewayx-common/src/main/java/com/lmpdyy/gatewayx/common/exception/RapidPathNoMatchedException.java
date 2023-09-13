package com.lmpdyy.gatewayx.common.exception;

import com.lmpdyy.gatewayx.common.enums.ResponseCode;

/**
 * @ClassName RapidPathNoMatchedException
 * @description:
 * @author: nxlea
 * @create: 2023-09-13 15:56
 */
public class RapidPathNoMatchedException extends RapidBaseException{

    private static final long serialVersionUID = 4432817643267638057L;

    public RapidPathNoMatchedException() {
        this(ResponseCode.PATH_NO_MATCHED);
    }

    public RapidPathNoMatchedException(ResponseCode code) {
        super(code.getMessage(), code);
    }

    public RapidPathNoMatchedException(Throwable cause, ResponseCode code) {
        super(code.getMessage(), cause, code);
    }
}
