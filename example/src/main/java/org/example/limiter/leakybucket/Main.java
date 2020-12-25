package org.example.limiter.leakybucket;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        LeakyBucketLimiter limiter = new LeakyBucketLimiter();
        boolean flag = limiter.acquire();
    }
}
