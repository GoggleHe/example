package org.example.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;

import java.util.concurrent.TimeUnit;

/**
 *
 **/
public class MyHystrixCommand extends HystrixCommand<String> {

    protected MyHystrixCommand(Setter setter) {
        super(setter);
    }

    @Override
    public String run() throws Exception {
        TimeUnit.SECONDS.sleep(10);
        return "hello world";
    }

    @Override
    public String getFallback() {
        return "getFallback";
    }

}
