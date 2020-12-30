package org.example.dubbo.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 *
 **/
public class HystrixConfig {

    /*@Autowired
    private HystrixCircuitBreakerFactory factory;

    @Bean
    public Customizer<HystrixCircuitBreakerFactory> defaultConfig() {
        return (factory) -> factory.configureDefault(id -> HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("id"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(4000)));
    }*/

}
