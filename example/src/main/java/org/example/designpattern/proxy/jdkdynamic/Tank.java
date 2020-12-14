package org.example.designpattern.proxy.jdkdynamic;

public class Tank extends GameObject implements Movable, Fireable {

    @Override
    public void move() {
        System.out.println("move...");
    }

    @Override
    public void fire() {
        System.out.println("fire...");
    }
}
