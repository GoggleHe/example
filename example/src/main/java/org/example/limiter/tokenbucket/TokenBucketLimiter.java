package org.example.limiter.tokenbucket;

import java.util.concurrent.TimeUnit;

/**
 *
 **/
public class TokenBucketLimiter {
    //令牌桶大小
    private int size;
    //流入速度,表示每间隔多少毫秒添加一个令牌
    private long interval;
    //上次获取令牌的时间戳
    private long timestamp;
    //当前令牌数量
    private long currentSize;

    public TokenBucketLimiter(int size, long interval) {
        this.size = size;
        this.interval = interval;
    }

    public boolean tryAcquire() {
        long nowTimestamp = addToken();
        if (currentSize > 0) {
            timestamp = nowTimestamp;
            currentSize--;
            return true;
        }
        return false;
    }

    public void acquire() throws InterruptedException {
        do {
            long nowTimestamp = addToken();
            if (currentSize > 0) {
                timestamp = nowTimestamp;
                currentSize--;
            } else {
                TimeUnit.MILLISECONDS.sleep(interval);
            }
        } while (currentSize <= 0);
    }

    private long addToken() {
        long nowTimestamp = getNowTimestamp();
        long newSize = currentSize + (nowTimestamp - timestamp) / interval;
        currentSize = newSize < size ? newSize : size;
        return nowTimestamp;
    }

    private long getNowTimestamp() {
        return System.currentTimeMillis();
    }
}
