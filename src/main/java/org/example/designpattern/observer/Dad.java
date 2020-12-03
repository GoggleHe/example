package org.example.designpattern.observer;

/**
 *
 **/
public class Dad implements Observer{

    public void feed(){
        System.out.println("Dad is feeding");
    }

    @Override
    public void actionWakeUp(WakeUpEvent event) {
        feed();
    }
}
