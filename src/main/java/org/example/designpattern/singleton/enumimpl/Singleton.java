package org.example.designpattern.singleton.enumimpl;

public enum Singleton {
    INSTANCE;

    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        System.out.println(instance);
    }
}
