package org.example.designpattern.strategy;

public class Dog implements Comparable<Dog>{

    int weight;

    @Override
    public int compareTo(Dog o) {
        return this.weight - o.weight;
    }
}
