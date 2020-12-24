package org.example.dubbo.common.service;

import java.util.concurrent.CompletableFuture;

/**
 *
 **/
public interface AsyncService {

    String sayHello(String name);

    default CompletableFuture<String> sayHello(String name, boolean async) {
        return CompletableFuture.completedFuture(sayHello(name));
    }

}
