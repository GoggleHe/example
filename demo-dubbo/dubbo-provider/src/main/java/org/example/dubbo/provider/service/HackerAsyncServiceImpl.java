package org.example.dubbo.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;
import org.example.dubbo.common.service.HackerAsyncService;

import java.util.concurrent.TimeUnit;

/**
 *
 **/
@DubboService
public class HackerAsyncServiceImpl implements HackerAsyncService {

    @Override
    public String sayHello(String name) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hacker say hello to " + name;
    }
}
