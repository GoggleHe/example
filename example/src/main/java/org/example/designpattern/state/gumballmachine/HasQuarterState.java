package org.example.designpattern.state.gumballmachine;

/**
 *
 **/
public class HasQuarterState extends State {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("请不要重复投币！");
        returnQuarter();
    }

    @Override
    public void ejectQuarter() {
        returnQuarter();
        gumballMachine.setState(gumballMachine.noQuarterState);
    }

    @Override
    public void turnCrank() {
        System.out.println("转动曲轴，准备发糖");
        gumballMachine.setState(gumballMachine.soldState);
    }

    @Override
    public void dispense() {
        System.out.println("this method don't support");
    }

}
