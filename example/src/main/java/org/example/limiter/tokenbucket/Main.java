package org.example.limiter.tokenbucket;

import java.util.concurrent.TimeUnit;

/**
 *
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {


        Runnable runnable = () -> {
            try {
                long id = Thread.currentThread().getId();
                System.out.println("execute thread " + id);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        TokenBucketLimiter limiter = new TokenBucketLimiter(10, 3000);
        while (true) {
            limiter.acquire();

            Thread thread = new Thread(runnable);
            thread.start();

        }
    }
}
