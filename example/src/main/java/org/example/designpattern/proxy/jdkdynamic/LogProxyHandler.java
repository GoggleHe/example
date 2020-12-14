package org.example.designpattern.proxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogProxyHandler implements InvocationHandler {
    GameObject tank;

    public LogProxyHandler(GameObject tank) {
        this.tank = tank;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy invoke");
        Object invoke = method.invoke(tank);
        return invoke;
    }
}
