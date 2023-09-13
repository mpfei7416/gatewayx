package com.lmpdyy.gatewayx.common.exception;

import com.lmpdyy.gatewayx.common.enums.ResponseCode;

/**
 * @ClassName RapidResponseException
 * @description:
 * @author: nxlea
 * @create: 2023-09-13 15:58
 */
public class RapidResponseException extends RapidBaseException{


    private static final long serialVersionUID = 7982671515322816866L;

    public RapidResponseException() {
        this(ResponseCode.INTERNAL_ERROR);
    }

    public RapidResponseException(ResponseCode code) {
        super(code.getMessage(), code);
    }


    public RapidResponseException(Throwable cause, ResponseCode code) {
        super(code.getMessage(), cause, code);
        this.code = code;
    }

}
