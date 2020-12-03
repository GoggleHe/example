package org.example.designpattern.visitor;

/**
 *
 **/
public class CorpVisitor implements ComputerPartVisitor {
    private double price;
    @Override
    public void visit(KeyBoard keyboard) {
        price += keyboard.getPrice() * 0.8;
    }

    @Override
    public void visit(Mouse mouse) {
        price += mouse.getPrice() * 0.8;
    }

    @Override
    public void visit(Monitor monitor) {
        price += monitor.getPrice() * 0.8;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
