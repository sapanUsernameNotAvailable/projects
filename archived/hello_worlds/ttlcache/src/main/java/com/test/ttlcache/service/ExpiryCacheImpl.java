package com.test.ttlcache.service;

import com.test.ttlcache.model.CacheEntry;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExpiryCacheImpl<K, V> implements ExpiryCache<K, V> {

    private final Map<K, CacheEntry<K, V>> cacheMap = new ConcurrentHashMap<K, CacheEntry<K, V>>();
    private Lock lock = new ReentrantLock();

    public ExpiryCacheImpl(final int milliSecondSleepTime) {

        try {
            Thread cleanerThread = new Thread() {
                @Override
                public void run() {
                    try {
                        while (true) {

                            Set<Map.Entry<K, CacheEntry<K, V>>> entrySet = cacheMap.entrySet();
                            Iterator<Map.Entry<K, CacheEntry<K, V>>> cacheEntryIt = entrySet.iterator();
                            while (cacheEntryIt.hasNext()) {
                                Map.Entry<K, CacheEntry<K, V>> cacheEntry = cacheEntryIt.next();
                                if (cacheEntry.getValue().isExpired()) {
                                    lock.lock();
                                    try {
                                        cacheMap.remove(cacheEntry.getKey());
                                    } finally {
                                        lock.unlock();
                                    }
                                }
                            }
                            Thread.sleep(milliSecondSleepTime);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            cleanerThread.setPriority(Thread.MIN_PRIORITY);
            cleanerThread.start();
            cleanerThread.setDaemon(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // default configuration
    public ExpiryCacheImpl() {
        this(1000);
    }

    @Override
    // put complexity O(1);
    public void put(K key, V value, int ttl, TimeUnit timeUnit) {
        lock.lock();
        try {
            cacheMap.put(key, new CacheEntry<K, V>(key, value, ttl, timeUnit));
        } finally {
            lock.unlock();
        }
    }

    @Override
    // get complexity O(1);
    public V get(K key) {
        CacheEntry<K, V> cacheEntry = cacheMap.get(key);
        return cacheEntry == null ? null : cacheEntry.getValue();
    }
    
    public int getCacheSize() {
        return cacheMap.size();
    }
}
