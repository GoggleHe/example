package org.example.dubbo.consumer.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.example.dubbo.common.service.AsyncService;
import org.example.dubbo.common.service.CompletableFutureService;
import org.example.dubbo.common.service.HackerAsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 *
 **/
@RestController
public class AsyncController {

    @DubboReference
    private CompletableFutureService completableFutureService;

    @DubboReference
    private AsyncService asyncService;

    @DubboReference(methods = {@Method(name = "sayHello", sent = false, async = true)})
    private HackerAsyncService hackerAsyncService;

    @GetMapping("/async/sayHello")
    public String sayHello(@RequestParam(defaultValue = "GoggleHe") String name) {
        CompletableFuture<String> completableFuture = completableFutureService.sayHello(name);
        completableFuture.whenComplete((u, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println(u);
            }
        });
        System.out.println("say hello end...");
        return "async say hello end";
    }

    @GetMapping("/asyncRpc/sayHello")
    public String asyncHello(@RequestParam(defaultValue = "GoggleHe") String name) {
        // 此调用会立即返回null

        // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        /*String res = asyncService.sayHello("world");
        System.out.println("res = " + res);
        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();
        // 为Future添加回调
        helloFuture.whenComplete((retValue, exception) -> {
            if (exception == null) {
                System.out.println(retValue);
            } else {
                exception.printStackTrace();
            }
        });*/

        /*CompletableFuture<String> helloFuture = RpcContext.getContext().asyncCall(() -> asyncService.sayHello("oneway call request1"));

        try {
            String s = helloFuture.get();
            System.out.println("s = " + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("say hello end...");*/

        CompletableFuture<String> defaultFuture = asyncService.sayHello("default", true);
        defaultFuture.whenComplete((u, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println("u = " + u);
            }
        });
        System.out.println("say hello end...");
        return "async rpc say hello end";
    }

    @GetMapping("/hacker/sayHello")
    public String hackerSayHello(@RequestParam(defaultValue = "GoggleHe") String name) {
        String s = hackerAsyncService.sayHello(name);
        System.out.println("end s = " + s);
        return "hacker async say hello end";
    }

}
