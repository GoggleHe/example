package org.example.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 **/
public class Branch extends Node {

    public Branch(String name) {
        super.name = name;
    }

    private List<Node> children = new ArrayList<>();

    public void addChild(Leaf node) {
        children.add(node);
    }

    @Override
    public String printName() {
        return super.name;
    }

}
