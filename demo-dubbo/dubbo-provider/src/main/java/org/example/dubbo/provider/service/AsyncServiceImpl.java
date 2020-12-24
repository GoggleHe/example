package org.example.dubbo.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;
import org.example.dubbo.common.service.AsyncService;

import java.util.concurrent.TimeUnit;

/**
 *
 **/
@DubboService
public class AsyncServiceImpl implements AsyncService {
    @Override
    public String sayHello(String name) {
        System.out.println("provider say hello to " + name);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name;
    }
}
