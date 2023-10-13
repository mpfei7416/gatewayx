package com.lmpdyy.gatewayx.core.netty.processor.filter;

import lombok.Data;

/**
 * @ClassName FilterConfig
 * @description: 所有过滤器配置类实现的base 类
 * @author: nxlea
 * @create: 2023-10-13 14:26
 */

@Data
public class FilterConfig {

    /**
     * 是否打印日志
     */
    private boolean loggable = false;
}
