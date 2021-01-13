package org.example.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);

        semaphore.acquire();
        semaphore.acquire();
        for (int i = 0; i < 5; i++) {
            semaphore.acquire();

            System.out.println("haha");

            semaphore.release();
        }
        semaphore.release();
        semaphore.release();

    }
}
