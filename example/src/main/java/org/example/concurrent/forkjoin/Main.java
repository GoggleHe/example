package org.example.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        FibonacciForkJoinTask forkJoinTask = new FibonacciForkJoinTask(7);
        Integer invoke = forkJoinTask.invoke();
        System.out.println(invoke);
    }
}
