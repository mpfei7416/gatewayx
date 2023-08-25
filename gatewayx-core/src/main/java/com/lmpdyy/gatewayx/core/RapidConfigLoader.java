package com.lmpdyy.gatewayx.core;


import com.lmpdyy.gatewayx.common.util.PropertiesUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName RapidConfigLoader
 * @description: 网关配置信息加载，
 *   网关配置加载规则【加载顺序规则】: 优先级高的覆盖优先级低的配置信息
 *      1、运行参数
 *      2、JVM 参数
 *      3、环境变量参数
 *      4、配置文件
 *      5、内部RapidConfig 对象的默认值
 * @author: nxlea
 * @create: 2023-08-24 14:33
 */
@Slf4j
public class RapidConfigLoader {

    private static final String CONFIG_EVN_PREFIEX = "RAPID_";

    private static final String CONFIG_JVM_PREFIEX = "RAPID.";

    private static final String CONFIG_FILE = "rapid.properties";

    private static final  RapidConfigLoader INSTANCE = new RapidConfigLoader();

    private RapidConfig rapidConfig = new RapidConfig();

    public static RapidConfigLoader getInstance() {
        return INSTANCE;
    }

    public static RapidConfig getRapidConfig(){
        return INSTANCE.rapidConfig;
    }

    public RapidConfig load(String args[]) {
        // 根据优先级高低创建RapidConfig 对象

        // 1、 配置文件
        {
            InputStream inputStream = RapidConfigLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
            if (inputStream != null) {
                Properties properties = new Properties();
                try {
                    properties.load(inputStream);
                    PropertiesUtils.properties2Object(properties, rapidConfig);
                } catch (IOException e) {
                    log.warn("#RapidConfigLoader# load config file: {} is error info {}", CONFIG_FILE, e.getMessage());
                    throw new RuntimeException(e);
                }finally {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }

        // 2、环境变量

        {
            Map<String, String> getenv = System.getenv();
            Properties properties = new Properties();
            properties.putAll(getenv);
            PropertiesUtils.properties2Object(properties, rapidConfig, CONFIG_EVN_PREFIEX);
        }

        // 3、JVM参数

        {
            Properties properties = System.getProperties();
            PropertiesUtils.properties2Object(properties, rapidConfig, CONFIG_JVM_PREFIEX);
        }

        //4、运行参数

        {
            if (args != null && args.length > 0) {
                Properties properties = new Properties();
                for (String arg : args) {
                    if (arg.startsWith("--") && arg.contains("=")) {
                        properties.put(arg.substring(2, arg.indexOf("=")), arg.substring(arg.indexOf("=") + 1));
                    }
                    PropertiesUtils.properties2Object(properties, rapidConfig);
                }
            }
        }

        return rapidConfig;
    }
}
