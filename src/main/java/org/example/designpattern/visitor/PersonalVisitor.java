package org.example.designpattern.visitor;

/**
 *
 **/
public class PersonalVisitor implements ComputerPartVisitor {

    private double price;

    @Override
    public void visit(KeyBoard keyboard) {
        System.out.println("visit keyboard");
        price += keyboard.getPrice();
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("visit mouse");
        price += mouse.getPrice();
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("visit monitor");
        price += monitor.getPrice();
    }

    @Override
    public double getPrice() {
        return price;
    }
}
