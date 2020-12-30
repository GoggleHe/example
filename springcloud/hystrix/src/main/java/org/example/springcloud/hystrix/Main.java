package org.example.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 *
 **/
public class Main {

    public static void main(String[] args) {

        HystrixCommand<Integer> command = new HystrixCommand<Integer>(() -> "") {
            @Override
            protected Integer run() throws Exception {
                return null;
            }
        };

        command.execute();
    }

}
