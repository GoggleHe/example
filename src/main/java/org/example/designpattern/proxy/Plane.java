package org.example.designpattern.proxy;

/**
 *
 **/
public class Plane implements Flyable{
    @Override
    public void fly() {
        System.out.println("fly with engine");
    }
}
