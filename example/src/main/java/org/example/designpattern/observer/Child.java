package org.example.designpattern.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 **/
public class Child {

    private List<Observer> observers = new ArrayList<>();


    public void wakeUp(){
        System.out.println("child is wake up and crying");
        WakeUpEvent bed = new WakeUpEvent(new Date(), "bed");
        for (Observer observer : observers) {
            observer.actionWakeUp(bed);
        }
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

}
