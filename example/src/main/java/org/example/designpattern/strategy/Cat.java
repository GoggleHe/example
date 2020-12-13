package org.example.designpattern.strategy;

public class Cat implements Comparable<Cat> {

    int height;

    public Cat() {
    }

    public Cat(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Cat o) {
        return this.height - o.height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                '}';
    }
}
