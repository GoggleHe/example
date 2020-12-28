package org.example.dubbo.consumer.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.dubbo.common.service.HystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 **/
@RestController
public class HystrixController {

    @DubboReference
    private HystrixService hystrixService;

    @GetMapping("/hystrix/hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        return hystrixService.sayHello(name);
    }

}
