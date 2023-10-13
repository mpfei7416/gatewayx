package com.lmpdyy.gatewayx.core.netty.processor.filter;

import java.lang.annotation.*;

/**
 * @InterfaceName Filter
 * @description:  过滤器注解类
 * @author: nxlea
 * @create: 2023-10-13 14:20
 **/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Filter {

    /**
     * 过滤器的唯一id ，必填属性
     * @return
     */
    String id();

    /**
     *  过滤器的名字
     * @return
     */
    String name() default "";

    /**
     *  过滤器的类型
     * @return
     */
    ProcessorFilterType value();


    /**
     * 过滤器的排序，按照此排序从小到大依次执行过滤器
     */
    int order() default 0;

}
