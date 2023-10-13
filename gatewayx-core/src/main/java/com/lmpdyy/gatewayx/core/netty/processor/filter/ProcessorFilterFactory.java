package com.lmpdyy.gatewayx.core.netty.processor.filter;

import com.lmpdyy.gatewayx.core.context.Context;

import java.util.List;

/**
 * @ClassName ProcessorFilterFactory
 * @description: 过滤器工厂接口
 * @author: nxlea
 * @create: 2023-10-13 15:05
 */
public interface ProcessorFilterFactory {

    /**
     *  根据过滤器类型添加一组过滤器， 用于构建过滤器链
     * @param filterType
     * @param filters
     * @throws Exception
     */
    void buildFilterChain(ProcessorFilterType filterType, List<ProcessorFilter<Context>> filters) throws Exception;


    /**
     * 正常情况下执行过滤器链
     * @param ctx
     * @throws Exception
     */
    void doFilterChain(Context ctx) throws Exception;


    /**
     *错误，异常情况下执行的过滤器链
     * @param ctx
     * @throws Exception
     */
    void doErrorFilterChain(Context ctx) throws Exception;


    /**
     * 获取指定类型的过滤器
     * @param t
     * @return
     * @param <T>
     * @throws Exception
     */
    <T> T getFilter(Class<T> t) throws  Exception;

    /**
     * 根据过滤器ID 获取指定的过滤器
     * @param filterId
     * @return
     * @param <T>
     * @throws Exception
     */
    <T> T getFilter(String filterId) throws Exception;


}
