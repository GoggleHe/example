package org.example.designpattern.proxy;

import java.util.concurrent.TimeUnit;

/**
 *
 **/
public class FlyProxy implements Flyable{
    private Flyable flyable;

    public FlyProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        flyable.fly();
        long end = System.currentTimeMillis();
        System.out.println("fly time " + TimeUnit.MICROSECONDS.toSeconds(end - start)+" seconds");
    }
}
