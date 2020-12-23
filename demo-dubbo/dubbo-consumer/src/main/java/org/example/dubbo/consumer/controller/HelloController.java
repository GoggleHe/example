package org.example.dubbo.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.example.dubbo.common.service.CallbackListener;
import org.example.dubbo.common.service.CallbackService;
import org.example.dubbo.common.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Hello服务API
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-25 17:22
 */
@RestController
@Slf4j
public class HelloController {

    @Reference
    private HelloService helloService;
    @Reference
    private CallbackService callbackService;

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(defaultValue = "xkcoding") String name) {
        log.info("i'm ready to call someone......");
        return helloService.sayHello(name);
    }

    @GetMapping("/callback")
    public String callback(@RequestParam(defaultValue = "hello") String key){
        callbackService.addListener(key, new CallbackListener() {
            @Override
            public void changed(String msg) {
                System.out.println(msg);
            }
        });
        return "callback";
    }
}
