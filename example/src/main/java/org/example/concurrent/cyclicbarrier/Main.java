package org.example.concurrent.cyclicbarrier;

import java.util.concurrent.*;

/**
 * CyclicBarrier
 * 循环屏障，等到所有的线程都调用都准备好，调用了await方法，所有线程才继续往下执行
 **/
public class Main {
    /**
     * @param args
     * @throws BrokenBarrierException
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, TimeoutException {
        CyclicBarrier barrier = new CyclicBarrier(8);

        ExecutorService pool = Executors.newFixedThreadPool(8);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 8; i++) {
            TimeUnit.SECONDS.sleep(1);
            pool.execute(() -> {
                try {
                    barrier.await();
                    System.out.println("go go go!");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        long end = System.currentTimeMillis();
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(end - start) + "秒");
    }
}
