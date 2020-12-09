package org.example.designpattern.state.gumballmachine;

/**
 *
 **/
public class GumballMachine extends State {
    public State noQuarterState = new NoQuarterState(this);
    public State hasQuarterState = new HasQuarterState(this);
    public State soldState = new SoldState(this);
    public State soldOutState = new SoldOutState(this);

    private State state = soldOutState;
    private int candyCount = 0;

    public GumballMachine(int count) {
        this.candyCount = count;
        if (count > 0)
            setState(noQuarterState);
    }

    @Override
    public void insertQuarter() {
        state.insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    @Override
    public void turnCrank() {
        state.turnCrank();
    }

    @Override
    public void dispense() {
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setCandyCount(int candyCount) {
        this.candyCount = candyCount;
    }

    public int getCandyCount() {
        return candyCount;
    }

}
