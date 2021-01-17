package org.example.limiter.leakybucket;

import java.util.concurrent.TimeUnit;

/**
 *
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(25 * 12);

        Runnable runnable = () -> {
            try {
                long id = Thread.currentThread().getId();
                System.out.println("execute thread " + id);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        LeakyBucketLimiter limiter = new LeakyBucketLimiter(3000);
        while (true) {
            long start = System.currentTimeMillis();
            limiter.acquire();
            long end = System.currentTimeMillis();
//            System.out.println(end - start);

            Thread thread = new Thread(runnable);
            thread.start();

        }
    }
}
