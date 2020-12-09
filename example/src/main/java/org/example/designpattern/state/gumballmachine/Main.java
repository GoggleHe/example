package org.example.designpattern.state.gumballmachine;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine(10);
        machine.insertQuarter();
        System.out.println(machine.getCandyCount());
        machine.turnCrank();
        System.out.println(machine.getCandyCount());
        machine.dispense();
        System.out.println(machine.getCandyCount());
        machine.insertQuarter();
        machine.insertQuarter();
        machine.insertQuarter();
        machine.turnCrank();
        machine.dispense();
        machine.dispense();
        System.out.println(machine.getCandyCount());
    }
}
