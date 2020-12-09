package org.example.designpattern.observer;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.attach(new Dad());
        child.attach(new Mum());
        child.attach(new Dog());
        child.wakeUp();
    }
}
