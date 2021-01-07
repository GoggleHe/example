package org.example.spring;

import org.example.spring.beans.lifestyle.SpringBoy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 **/
public class BeanLifeStyleTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-boy-spring.xml");
        SpringBoy hello = (SpringBoy) context.getBean("SpringBoy");
//        System.out.println(hello);
        context.registerShutdownHook();
    }

}
