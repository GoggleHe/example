package org.example.algorithm.fsm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 **/
public class Main {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("haha");
            }
        });
        thread.start();
        thread.join();
        Thread.yield();
        System.out.println("hehe");

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

        LockSupport.park();
        LockSupport.parkUntil(System.currentTimeMillis());
    }
}
