package org.example.designpattern.observer;

/**
 *
 **/
public class Dog implements Observer{

    public void bark(){
        System.out.println("Dog is barking");
    }

    @Override
    public void actionWakeUp(WakeUpEvent event) {
        bark();
    }
}
