package org.example.concurrent.application.dispather;

import java.util.Set;
import java.util.concurrent.*;

public class OrderDispatcher {

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(200);

    private Set<String> drivers = new CopyOnWriteArraySet<>();

    public OrderDispatcher() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30));
        while (true) {
            Runnable runnable = () -> {
                System.out.println("接单开始");
                String orderId = null;
                try {
                    orderId = queue.take();
                    System.out.println("接单开始：" + orderId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (!drivers.contains(orderId)) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("接单成功：" + orderId);
                drivers.remove(orderId);

            };

            try {
                executor.submit(runnable);
            } catch (RejectedExecutionException e) {
//                e.printStackTrace();
            }

            ExecutorService pool = Executors.newFixedThreadPool(10);
        }

    }

    public void addOrder(String orderId) {
        System.out.println("下单：" + orderId);
        queue.add(orderId);
    }

    public void removeOrder(String orderId) {
        queue.remove(orderId);
    }

    public void watch(String driverId) {
        System.out.println("听单：" + driverId);
        drivers.add(driverId);
    }

    public void cancelWatch(String driverId) {
        drivers.remove(driverId);
    }
}
