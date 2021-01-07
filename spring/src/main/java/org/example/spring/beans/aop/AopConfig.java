package org.example.spring.beans.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 **/
@Configuration
@ComponentScan(basePackages = "org.example.spring.beans.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {
}
