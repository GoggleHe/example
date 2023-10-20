package org.example.unittest;

public class Calculator {

    private Storage storage;

    public Calculator() {

    }

    public Calculator(Storage storage) {
        this.storage = storage;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int add(int i) {
        Integer key = storage.load("key");
        return key + i;
    }

}
