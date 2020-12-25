package org.example.limiter.leakybucket;

/**
 *
 **/
public class LeakyBucketLimiter {

    private long interval;

    public boolean acquire() {
        return false;
    }
}
