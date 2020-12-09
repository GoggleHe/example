package org.example.designpattern.state.simple;

/**
 *
 **/
public class StopState implements State {
    @Override
    public void operation(Context context) {
        System.out.println("execute stop state");
        context.setState(this);
    }
}
