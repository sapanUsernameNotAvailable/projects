package com.test.ttlcache;

import java.util.HashMap;
import java.util.Map;

public class MockDao<K, V> {

    Map<K, V> mockDatabase = new HashMap<K, V>();
    final int delayTime;
    
    MockDao(int delayTime) {
        this.delayTime = delayTime;
    }
    
    MockDao() {
        this(500); // 500 ms
    }
 
    public void putData(K key, V value) {
        mockDatabase.put(key, value);
    }
    
    public V getData(K key) {
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mockDatabase.get(key);
    }
}