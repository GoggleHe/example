package org.example.dubbo.common.service;

/**
 *
 **/
public class HelloServiceMock implements HelloService {

    @Override
    public String sayHello(String name) {
        return "mock";
    }

}
