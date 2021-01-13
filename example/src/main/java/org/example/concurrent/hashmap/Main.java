package org.example.concurrent.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 *
 **/
public class Main {
    private static volatile int index = 0;

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("hashmap-put-deadlock-test");
                return thread;
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            pool.execute(new RunnableImpl(map, "thead-0-"));
        }
    }
}
