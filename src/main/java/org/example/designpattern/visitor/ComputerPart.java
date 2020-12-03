package org.example.designpattern.visitor;

public interface ComputerPart {

    void accept(ComputerPartVisitor computerPartVisitor);

    double getPrice();

}
