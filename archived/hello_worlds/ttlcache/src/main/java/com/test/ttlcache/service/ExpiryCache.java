package com.test.ttlcache.service;

import java.util.concurrent.TimeUnit;

public interface ExpiryCache<K, V> {

    public void put(K key, V value, int ttl, TimeUnit timeUnit);
    public V get(K key);
}
