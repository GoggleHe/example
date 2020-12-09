package org.example.designpattern.visitor;

/**
 *
 **/
public class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer() {
        this.parts = new ComputerPart[]{new KeyBoard(), new Monitor(), new Mouse()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (int i = 0; i < parts.length; i++) {
            price += parts[i].getPrice();
        }
        return price;
    }
}
