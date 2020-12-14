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
        Future<String> take = completionService.poll();
        System.out.println(take);
        completionService.submit(task);
//        String s = submit.get();
//        System.out.println(s);


//        String s1 = submit1.get();
//        System.out.println(s1);

        /*Future<String> take = null;
        while ((take = completionService.take()) != null) {
            String res = take.get();
            System.out.println(res);
            System.out.println("aaaa");
        }*/

        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        completionService.submit(runnable, "hohohohohoho");
    }
}
