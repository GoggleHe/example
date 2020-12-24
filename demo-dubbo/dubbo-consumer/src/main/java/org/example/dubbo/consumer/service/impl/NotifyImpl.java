package org.example.dubbo.consumer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dubbo.common.service.Notify;
import org.springframework.stereotype.Component;

/**
 *
 **/
@Component("notify")
@Slf4j
public class NotifyImpl implements Notify {
    @Override
    public void onInvoke(String parameter) {
        log.info("onInvoke({})", parameter);
    }

    @Override
    public void onReturn(String res, String parameter) {
        log.info("onReturn({}, {})", res, parameter);
    }

    @Override
    public void onThrow(Throwable throwable, String parameter) {
        log.error("onThrow({})", parameter, throwable);
    }
}
