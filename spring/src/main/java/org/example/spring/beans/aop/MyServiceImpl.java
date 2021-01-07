package org.example.spring.beans.aop;

import org.springframework.stereotype.Service;

/**
 *
 **/
@Service("myService")
public class MyServiceImpl implements MyService{

    @Override
    public String hello(String name) {
        System.out.println("service execute");
        return "hello " + name;
    }
}
