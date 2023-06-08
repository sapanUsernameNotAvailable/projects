package com.test.ttlcache.model;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CacheEntry<K, V> {

    final K key;
    final V data;
    final Date dateofExpiration;

    public CacheEntry(K key, V data, int ttl, TimeUnit timeUnit) {
        this.key = key;
        this.data = data;
        this.dateofExpiration = new Date(Calendar.getInstance().getTime().getTime() + timeUnit.toMillis(ttl));
    }
    
    public V getValue() {
        return data;
    }

    public boolean isExpired() {
        if (dateofExpiration.before(new java.util.Date())) {
            return true;
        } else {
            return false;
        }
    }
}
