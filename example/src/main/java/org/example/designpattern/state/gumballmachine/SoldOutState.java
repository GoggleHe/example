package org.example.designpattern.state.gumballmachine;

/**
 *
 **/
public class SoldOutState extends State{
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("糖果已经售尽");
        returnQuarter();
    }

    @Override
    public void ejectQuarter() {
        System.out.println("没有投币，无法退币");
    }

    @Override
    public void turnCrank() {
        System.out.println("糖果已经售尽");
    }

    @Override
    public void dispense() {
        System.out.println("糖果已经售尽");
    }
}
