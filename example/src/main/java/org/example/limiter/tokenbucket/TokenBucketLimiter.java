package org.example.limiter.tokenbucket;

import java.util.concurrent.TimeUnit;

/**
 *
 **/
public class TokenBucketLimiter {
    //令牌桶大小
    private int burst;
    //流入速度,表示每间隔多少毫秒添加一个令牌
    private long interval;
    //当前令牌数量
    private long currentSize;

    private long next;

    public TokenBucketLimiter(int burst, long interval) {
        this.burst = burst;
        this.interval = interval;
    }

    private void reSync(long now) {
        //当前时间晚于下次token的时间，说明桶未满
        if (now > next) {
            //计算空余多少个令牌未发放
            long addSize = (now - next) / interval;
            //求桶中剩余令牌数目
            currentSize = Math.min(burst, currentSize + addSize);
            //重置下次token时间
            next = now;
        }
    }

    //本次token执行时间戳
    private synchronized long reserve(long now) {
        reSync(now);
        //本次token执行时间戳
        long at = next;
        //获取可用token数量
        long used = Math.min(1, currentSize);
        //下次token执行时间戳
        next += (interval * (1 - used));
        //重置桶中的token数量
        currentSize -= used;
        return at;
    }

    public void acquire() throws InterruptedException {
        long now = System.currentTimeMillis();
        long reserve = reserve(now);
        System.out.println("next = " + next);
        long waitTime = Math.max(reserve - now, 0L);
        if (waitTime > 0) {
            TimeUnit.MILLISECONDS.sleep(waitTime);
        }
    }

}
