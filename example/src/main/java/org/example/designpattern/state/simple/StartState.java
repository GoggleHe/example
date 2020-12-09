package org.example.designpattern.state.simple;

/**
 *
 **/
public class StartState implements State {

    @Override
    public void operation(Context context) {
        System.out.println("execute start state");
        context.setState(this);
    }

}
