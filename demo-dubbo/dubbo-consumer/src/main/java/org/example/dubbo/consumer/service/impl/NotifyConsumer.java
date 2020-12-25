package org.example.dubbo.consumer.service.impl;

import org.example.dubbo.common.service.HelloService;

/**
 *
 **/
public class NotifyConsumer {

    private HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    public String sayHello(String name){
        return helloService.sayHello(name);
    }
}
