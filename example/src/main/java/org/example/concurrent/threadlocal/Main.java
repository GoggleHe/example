package org.example.concurrent.threadlocal;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("hello world");

        String text = threadLocal.get();
        System.out.println(text);
    }
}
