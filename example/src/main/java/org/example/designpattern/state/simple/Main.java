package org.example.designpattern.state.simple;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.operation(context);

        StopState stopState = new StopState();
        stopState.operation(context);


    }
}
