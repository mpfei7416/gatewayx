package com.lmpdyy.gatewayx.core.netty.processor.filter;

import afu.org.checkerframework.checker.oigj.qual.O;

/**
 * @InterfaceName ProcessorFilter
 * @description: 执行过滤器的接口操作
 * @author: nxlea
 * @create: 2023-10-13 14:58
 **/
public interface ProcessorFilter<T> {


    /**
     * 过滤器是否执行的校验方法
     * @param t
     * @return
     * @throws Throwable
     */
    boolean check(T t) throws Throwable;


    /**
     * 真正执行过滤器的方法
     * @param t
     * @param args
     * @throws Throwable
     */
    void entry(T t, Object...args) throws Throwable;


    /**
     * 触发下一个过滤器执行
     * @param t
     * @param args
     * @throws Throwable
     */
    void fireNext(T t, Object...args) throws Throwable;



    /**
     * <B>概要说明：</B>对象传输的方法<BR>
     * @param t
     * @param args
     * @throws Throwable
     */
    void transformEntry(T t, Object... args) throws Throwable;


    /**
     * <B>概要说明：</B>过滤器初始化的方法，如果子类有需求则进行覆盖<BR>
     */
    default void init() throws Exception {

    }

    /**
     * <B>概要说明：</B>过滤器销毁的方法，如果子类有需求则进行覆盖<BR>
     */
    default void destroy() throws Exception {

    }

    /**
     * <B>方法名称：</B>refresh<BR>
     * <B>概要说明：</B>过滤器刷新的方法，如果子类有需求则进行覆盖<BR>
     */
    default void refresh() throws Exception {

    }

}
