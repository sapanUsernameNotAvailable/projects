package com.test.ttlcache.service;

public class ExpiryCacheFactory {

    // can be configured by property
    private static final int CONFIGURABLE_PURGING_JOB_SCHEDULE_TIME = 2000;
    
    public static final <K, V> ExpiryCache<K, V> getExpiryCache() {
        return new ExpiryCacheImpl<K, V>(CONFIGURABLE_PURGING_JOB_SCHEDULE_TIME);
    }
    
    public static final <K, V> ExpiryCache<K, V> getExpiryCache(int purgingJobScheduleTime) {
        return new ExpiryCacheImpl<K, V>(purgingJobScheduleTime);
    }
}
