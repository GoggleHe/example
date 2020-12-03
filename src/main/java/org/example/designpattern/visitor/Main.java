package org.example.designpattern.visitor;

/**
 *
 **/
public class Main {

    public static void main(String[] args) {
        ComputerPart computer = new Mouse();
        ComputerPartVisitor personalVisitor = new CorpVisitor();
        computer.accept(personalVisitor);
        double price = personalVisitor.getPrice();
        System.out.println(price);
    }

}
