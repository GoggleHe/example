package org.example.designpattern.flyweight;

/**
 *
 **/
public class Connection {
    private boolean isAlive;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive() {
        if (!isAlive) {
            isAlive = true;
        }
    }

    public void disconnect() {
        if (isAlive) {
            isAlive = false;
        }
    }
}
