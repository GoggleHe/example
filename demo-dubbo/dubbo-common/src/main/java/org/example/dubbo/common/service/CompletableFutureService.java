package org.example.dubbo.common.service;

import java.util.concurrent.CompletableFuture;

public interface CompletableFutureService {

    CompletableFuture<String> sayHello(String name);

}
