package org.example.designpattern.observer;

/**
 *
 **/
public class Mum implements Observer {

    public void hug(){
        System.out.println("mum is hugging");
    }

    @Override
    public void actionWakeUp(WakeUpEvent event) {
        hug();
    }
}
