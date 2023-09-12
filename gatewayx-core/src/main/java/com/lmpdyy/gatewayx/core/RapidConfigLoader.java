package com.lmpdyy.gatewayx.core;

import com.lmpdyy.gatewayx.common.util.PropertiesUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.PropertiesUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName RapidConfigLoader
 * @description:  网关 配置信息加载类
 *  网关配置加载规则： 优先级顺序： 优先级高的覆盖优先级低的配置
 *      运行参数最高 ->  jvm 参数  -> 环境变量 -> 配置文件 ——> 内部RapidConfig 对象默认值（最低   ）
 * @author: nxlea
 * @create: 2023-09-11 17:26
 */
@Slf4j
public class RapidConfigLoader {

    private static final String CONFIG_EVM_PREFIEX = "RAPID_";

    private static final String CONFIG_JVM_PREFIEX = "rapid.";

    private static final String CONFIG_FILE = "rapid.properties";

    private final static RapidConfigLoader INSTANCE = new RapidConfigLoader();

    private RapidConfig rapidConfig = new RapidConfig();

    public RapidConfigLoader() {
    }

    public static RapidConfigLoader getInstance() {
        return INSTANCE;
    }

    public static RapidConfig getRapidConfig() {
        return INSTANCE.rapidConfig;
    }

    public RapidConfig load(String args[]) {
        // 加载配置逻辑

        // 配置文件参数加载
        {
            InputStream inputStream = RapidConfigLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
            if (inputStream != null) {
                Properties properties = new Properties();
                try {
                    properties.load(inputStream);
                } catch (IOException e) {
                    log.warn("#RapidConfigLoader# load config file: {} is error", CONFIG_FILE, e);
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        // log.warn("");
                    }
                }
            }

        }

        // JVM 参数
        {
            Map<String, String> env = System.getenv();
            Properties properties = new Properties();
            properties.putAll(env);
            PropertiesUtils.properties2Object(properties, rapidConfig, CONFIG_JVM_PREFIEX);
        }


        // 运行参数
        {
            if (args != null && args.length > 0) {
                Properties properties = new Properties();
                for (String arg : args) {
                    properties.put(arg.substring(2, arg.indexOf("=")), arg.substring(arg.indexOf("=") + 1));
                }
                PropertiesUtils.properties2Object(properties, rapidConfig);
            }

        }
        return rapidConfig;
    }
}
