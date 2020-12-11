package org.example.concurrent.completionservice;

import java.util.concurrent.*;

/**
 *
 **/
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        CompletionService<String> completionService = new ExecutorCompletionService<>(fixedThreadPool);
        Callable<String> task = () -> "hello world!";
        Future<String> submit = completionService.submit(task);
        String s = submit.get();
        System.out.println(s);

        Runnable runnable = () -> {};
        Future<String> submit1 = completionService.submit(runnable, s);
        String s1 = submit1.get();
        System.out.println(s1);

    }
}
