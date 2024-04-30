package org.example.concurrent.locksupport;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread start");
            LockSupport.park();
            System.out.println("Thread exe");

            System.out.println("Thread end");
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.interrupt();

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        System.in.read();
    }
}
