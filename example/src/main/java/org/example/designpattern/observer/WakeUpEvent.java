package org.example.designpattern.observer;

import java.util.Date;

public class WakeUpEvent {

    private Date date;
    private String loc;

    public WakeUpEvent(Date date, String loc) {
        this.date = date;
        this.loc = loc;
    }
}
