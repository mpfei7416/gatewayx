package com.lmpdyy.gatewayx.core.netty.processor.filter;

/**
 * @ClassName ProcessorFilterType
 * @description: 过滤器类型定义
 * @author: nxlea
 * @create: 2023-10-13 14:16
 */
public enum ProcessorFilterType {

    PRE("PRE", "前置过滤器"),

    ROUTE("ROUTE", "中置过滤器"),

    ERROR("ERROR", "异常过滤器"),

    POST("POST", "中置过滤器");

    private String code;

    private String  message;

    ProcessorFilterType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
