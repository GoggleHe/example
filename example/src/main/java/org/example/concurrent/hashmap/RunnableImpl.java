package org.example.concurrent.hashmap;

import java.util.Map;

/**
 *
 **/
public class RunnableImpl implements Runnable {

    private Map<String, String> map;

    private String prefix;

    public RunnableImpl(Map<String, String> map, String prefix) {
        this.map = map;
        this.prefix = prefix;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            map.put(prefix + j, prefix);
        }
    }
}
