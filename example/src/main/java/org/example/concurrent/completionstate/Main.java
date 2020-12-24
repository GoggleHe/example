package org.example.concurrent.completionstate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {

//        CompletionStage<String> completionStage = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "hello";
//        });
//        CompletionStage<String> completionStage2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "world";
//        });
//
//        Consumer<String> consumer = (item) -> {
//            System.out.println("acceptEither " + item);
//        };
//
//        completionStage.acceptEither(completionStage2, consumer);
//
//
//        BiConsumer<String, String> biConsumer = (t, u) -> {
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("thenAcceptBoth " + t + " " + u);
//        };
//        long start = System.currentTimeMillis();
//        completionStage.thenAcceptBoth(completionStage2, biConsumer);
//
//        long end1 = System.currentTimeMillis();
//        System.out.println(TimeUnit.MILLISECONDS.toSeconds(end1 - start));
//
//        completionStage.thenAcceptBothAsync(completionStage2, biConsumer);
//        long end = System.currentTimeMillis();
//
//        System.out.println(TimeUnit.MILLISECONDS.toSeconds(end - end1));

        //验证是否异步
        /*CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("runAsync");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).thenRun(()-> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("thenRun");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).whenComplete((u,t) -> {
            System.out.println(u);
        });
        System.out.println("end");*/


        CompletableFuture<String> future = CompletableFuture.completedFuture("hello world");
        future.whenComplete((u,t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println("u = " + u);
            }
        });

        TimeUnit.SECONDS.sleep(100);
    }
}
