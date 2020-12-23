package org.example.dubbo.consumer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.example.dubbo.common.service.CompletableFutureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 *
 **/
@RestController
public class AsyncController {

    @Reference
    private CompletableFutureService completableFutureService;

    @GetMapping("/async/sayHello")
    public String sayHello(@RequestParam(defaultValue = "GoggleHe") String name) {
        CompletableFuture<String> completableFuture = completableFutureService.sayHello(name);
        completableFuture.whenComplete((u,t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println(u);
            }
        });
        System.out.println("say hello end...");
        return "async say hello end";
    }

}
