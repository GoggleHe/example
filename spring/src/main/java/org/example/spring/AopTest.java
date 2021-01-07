package org.example.spring;

import org.example.spring.beans.aop.AopConfig;
import org.example.spring.beans.aop.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 **/
public class AopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        MyService myService = (MyService) context.getBean("myService");
        String res = myService.hello("GoggleHe");
        System.out.println(res);
    }
}
