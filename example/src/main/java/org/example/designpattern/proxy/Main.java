package org.example.designpattern.proxy;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        FlyProxy proxy = new FlyProxy(new Bird());
        proxy.fly();

        FlyProxy proxy1 = new FlyProxy(new Plane());
        proxy1.fly();
    }
}
