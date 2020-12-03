package org.example.designpattern.visitor;

/**
 *
 **/
public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }

    @Override
    public double getPrice() {
        return 3000;
    }
}
