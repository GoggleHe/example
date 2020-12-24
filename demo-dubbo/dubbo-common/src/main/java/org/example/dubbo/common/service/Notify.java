package org.example.dubbo.common.service;

public interface Notify {

    void onInvoke(String parameter);

    void onReturn(String res, String parameter);

    void onThrow(Throwable throwable, String parameter);
}
