package org.example.designpattern.visitor;

public interface ComputerPartVisitor {

    void visit(KeyBoard keyboard);

    void visit(Mouse mouse);

    void visit(Monitor monitor);

    double getPrice();
}
