package org.example.tmp;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CacheUtils {
    private volatile static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    private volatile static Set<String> set = new HashSet<>();

    public static String get(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            if (set.contains(key)) {
                synchronized (key){
                    try {
                        key.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return map.get(key);
            } else {
                String hash = null;
                synchronized (key){
                    set.add(key);
                    hash = hash(key);
                    map.put(key, hash);
                    set.remove(key);
                    key.notifyAll();
                }
                return hash;
            }
        }
    }

    public static String hash(String key) {
        return key == null ? null : String.valueOf(key.hashCode());
    }
}
