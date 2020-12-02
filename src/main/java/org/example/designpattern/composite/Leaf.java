package org.example.designpattern.composite;

/**
 *
 **/
public class Leaf extends Node {

    public Leaf(String name) {
        super.name = name;
    }

    @Override
    public String printName() {
        return super.name;
    }
}
