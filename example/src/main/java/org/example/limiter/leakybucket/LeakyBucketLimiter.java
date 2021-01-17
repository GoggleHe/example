package org.example.limiter.leakybucket;

import java.util.concurrent.TimeUnit;

/**
 *
 **/
public class LeakyBucketLimiter {

    private long interval;

    private long next;

    public LeakyBucketLimiter(long interval) {
        this.interval = interval;
    }

    private synchronized long reverse(long now) {
        long reverse;
        if (now > next + interval) {
            reverse = now;
            next = reverse;
        } else {
            reverse = next + interval;
            next = reverse;
        }
        return reverse;
    }

    public void acquire() throws InterruptedException {
        long now = System.currentTimeMillis();
        long reverse = reverse(now);
        long waitTime = Math.max(reverse - now, 0L);
        if (waitTime > 0) {
            System.out.println("waitTime = " + waitTime);
            TimeUnit.MILLISECONDS.sleep(waitTime);
        }
    }
}
