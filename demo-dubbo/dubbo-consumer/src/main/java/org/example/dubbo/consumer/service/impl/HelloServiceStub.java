package org.example.dubbo.consumer.service.impl;

import org.example.dubbo.common.service.HelloService;

/**
 *
 **/
public class HelloServiceStub implements HelloService {
    private HelloService helloService;

    public HelloServiceStub(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {

        try {
            System.out.println("stub");
            return helloService.sayHello(name);
        } catch (Exception e) {
            return "exception";
        }
    }
}
