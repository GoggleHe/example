package org.example.designpattern.visitor;

/**
 *
 **/
public class KeyBoard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }

    @Override
    public double getPrice() {
        return 300;
    }
}
