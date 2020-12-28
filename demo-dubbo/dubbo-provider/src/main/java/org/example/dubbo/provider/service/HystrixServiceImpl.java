package org.example.dubbo.provider.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.dubbo.common.service.HystrixService;

import java.util.Map;

/**
 *
 **/
@DubboService
@Slf4j
public class HystrixServiceImpl implements HystrixService {


    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "0"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "0")
    })
    public String sayHello(String name) {
        log.info("sayhello to {}", name);
        return "say hello to " + name;
    }

    public String fallbackMethod(String name) {
        log.error("fallbackMethod to {}", name);
        return "fallbackMethod";
    }

}
