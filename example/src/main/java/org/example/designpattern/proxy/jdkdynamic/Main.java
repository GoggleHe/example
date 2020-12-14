package org.example.designpattern.proxy.jdkdynamic;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class, Fireable.class},
                new LogProxyHandler(tank));

        m.move();

        Fireable f = (Fireable) m;
        f.fire();
    }
}
