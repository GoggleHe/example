package org.example.concurrent.completefuture;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        /*ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello world", newFixedThreadPool);

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        lock.unlock();
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return UUID.randomUUID().toString();
        }).acceptEither(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return UUID.randomUUID().toString()+" acceptEither";
        }), (uuid) -> {
            System.out.println(uuid);
        });

        System.in.read();
       /* Callable<String> callable = () -> {
            TimeUnit.SECONDS.sleep(3);
            return "hello world";
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        String s = futureTask.get();
        System.out.println(s);*/
    }
}
