package org.example.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FibonacciForkJoinTask forkJoinTask = new FibonacciForkJoinTask(40);
//        Integer invoke = forkJoinTask.invoke();

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        Integer invoke = forkJoinPool.invoke(forkJoinTask);
        System.out.println(invoke);
        long end = System.currentTimeMillis();
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(end - start));
    }
}
