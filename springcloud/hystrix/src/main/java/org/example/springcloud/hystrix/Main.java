package org.example.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 *
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        HystrixCommandProperties.Setter properties = HystrixCommandProperties.Setter()
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);

        HystrixCommand.Setter setter = HystrixCommand.Setter.withGroupKey(new HystrixCommandGroupKey() {
            @Override
            public String name() {
                return "groupKey";
            }
        }).andCommandPropertiesDefaults(properties);

        MyHystrixCommand command = new MyHystrixCommand(setter);

        String execute = command.execute();
        System.out.println(execute);

        for (int i = 0; i < 20; i++) {
            String run = command.run();
            System.out.println(run);
        }


    }

}
