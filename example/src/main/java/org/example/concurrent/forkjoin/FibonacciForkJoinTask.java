package org.example.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 *
 **/
public class FibonacciForkJoinTask extends RecursiveTask<Integer> {
    private int num;

    public FibonacciForkJoinTask(int num) {
        this.num = num;
    }

    @Override
    protected Integer compute() {
        long id = Thread.currentThread().getId();
        System.out.println("thread id : " + id);
        if (num <= 0) {
            return 0;
        }
        if (num <= 2) {
            return 1;
        }
        FibonacciForkJoinTask left = new FibonacciForkJoinTask(num - 1);
        FibonacciForkJoinTask right = new FibonacciForkJoinTask(num - 2);
        left.fork();
        right.fork();

        //此行避免存在线程只监工不干活
        invokeAll(left, right);

        return left.join() + right.join();
    }

}
