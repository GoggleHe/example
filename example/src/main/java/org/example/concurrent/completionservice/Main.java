package org.example.concurrent.completionservice;

import java.util.concurrent.*;

/**
 *
 **/
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        CompletionService<String> completionService = new ExecutorCompletionService<>(fixedThreadPool);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Callable<String> task = () -> {
                TimeUnit.SECONDS.sleep(3);
                return "hello world! " + finalI;
            };
            completionService.submit(task);
        }
        while (true) {
            Future<String> take = completionService.take();
            String s = take.get();
            System.out.println(s);
        }
    }
}
