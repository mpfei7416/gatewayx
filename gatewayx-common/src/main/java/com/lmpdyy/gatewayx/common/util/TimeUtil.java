package com.lmpdyy.gatewayx.common.util;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TimeUtil
 * @description:
 * @author: nxlea
 * @create: 2023-08-22 15:16
 */
public class TimeUtil {
    private static volatile long currentTimeMillis;

    static {
        currentTimeMillis = System.currentTimeMillis();
        Thread daemon = new Thread(new Runnable() {
            @Override
            public void run() {
                currentTimeMillis = System.currentTimeMillis();
                try{
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        });
        daemon.setDaemon(true);
        daemon.setName("common-fd-time-tick-thread");
        daemon.start();
    }
}
