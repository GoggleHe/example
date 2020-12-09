package org.example.designpattern.proxy;

/**
 *
 **/
public class Bird  implements Flyable{
    @Override
    public void fly() {
        System.out.println("fly with wings");
    }
}
