package org.eaxmple.spring;

import org.eaxmple.spring.beans.cycledepency.SpringBeanA;
import org.eaxmple.spring.beans.cycledepency.SpringBeanB;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 **/
public class CycleDependencyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-cycle-dependency.xml");
        SpringBeanA springBeanA = (SpringBeanA) context.getBean("springBeanA");
        System.out.println(springBeanA.getSpringBeanB());
        SpringBeanB springBeanB = (SpringBeanB) context.getBean("springBeanB");
        System.out.println(springBeanB.getSpringBeanA());
    }
}
