package org.example.spring.beans.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 **/
@Aspect
@Component
public class MyAspect {
    /**
     * 切点
     */
    @Pointcut("execution(* org.example.spring.beans.aop..*(..)) && args(arg)")
    public void pointcut(String arg) {

    }

    @Before(value = "pointcut(arg)")
    public void before(JoinPoint joinPoint, String arg) {
        Object[] args = joinPoint.getArgs();
        System.out.println("proxy before... args = " + args[0] + " arg = " + arg);
    }

    @After("pointcut(arg)")
    public void after(JoinPoint joinPoint, String arg) {
        Object target = joinPoint.getTarget();
        System.out.println("proxy after... target = " + target);
    }

    @AfterReturning(value = "pointcut(arg)", returning = "returnObj")
    public void afterReturning(JoinPoint joinPoint, String arg, Object returnObj) {
        System.out.println("proxy afterReturning returnObj = " + returnObj);
    }

    @AfterThrowing(value = "pointcut(arg)", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, String arg, Throwable throwable) {
        System.out.println("proxy afterThrowing");
    }

    @Around(value = "pointcut(arg)")
    public Object around(ProceedingJoinPoint pj, Object arg) {
        Object res = null;
        try {
            System.out.println("around before ...");
            Object[] args = pj.getArgs();
            res = pj.proceed(args);
            System.out.println("around after ...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return res;
    }
}
