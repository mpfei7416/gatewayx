package com.lmpdyy.gatewayx.common.util;

import java.io.Serializable;

/**
 * @ClassName Three
 * @description:
 * @author: nxlea
 * @create: 2023-08-22 15:21
 */
public class Three<T1, T2, T3> implements Serializable {

    private static final long serialVersionUID = 6898376664250269861L;

    private T1 object1;
    private T2 object2;
    private T3 object3;

    public Three(T1 object1, T2 object2, T3 object3) {
        this.object1 = object1;
        this.object2 = object2;
        this.object3 = object3;
    }

    public T1 getObject1() {
        return object1;
    }

    public void setObject1(T1 object1) {
        this.object1 = object1;
    }

    public T2 getObject2() {
        return object2;
    }

    public void setObject2(T2 object2) {
        this.object2 = object2;
    }

    public T3 getObject3() {
        return object3;
    }

    public void setObject3(T3 object3) {
        this.object3 = object3;
    }
}
