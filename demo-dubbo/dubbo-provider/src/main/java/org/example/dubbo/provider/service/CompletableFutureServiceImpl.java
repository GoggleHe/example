package org.example.dubbo.provider.service;

import org.apache.dubbo.config.annotation.Service;
import org.example.dubbo.common.service.CompletableFutureService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 **/
@Service
public class CompletableFutureServiceImpl implements CompletableFutureService {
    @Override
    public CompletableFuture<String> sayHello(String name) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello " + name;
        });
    }
}
