package com.lmpdyy.gatewayx.core;

/**
 * @ClassName Bootstrap
 * @description: 启动类入口
 * @author: nxlea
 * @create: 2023-08-23 10:06
 */
public class Bootstrap {

    public static void main(String[] args) {
        // 1、加载网关的配置信息
        RapidConfigLoader.getInstance().load(args);


        // 2、 插件初始化

        // 3、获取注册中心服务信息放入本地缓存 -->  初始化服务注册器， 动态监听配置的新增，修改，删除操作

        //4、启动容器，

    }

}
