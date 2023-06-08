package com.test.ttlcache;

import com.test.ttlcache.service.ExpiryCache;
import com.test.ttlcache.service.ExpiryCacheFactory;
import com.test.ttlcache.service.ExpiryCacheImpl;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.Assert;

public class UnitTest {

    MockDao<String, String> mockDao = new MockDao<String, String>();
    ExpiryCache<String, String> cache = ExpiryCacheFactory.getExpiryCache();
    private static final int FULL_CACHE_SIZE = 26;

    @Test
    public void testCacheTimeLess() {
        populateDataBase();
        long nonCacheAccess = timeNonCacheAccess();
        long cacheAccess = timeCachedAccess();
        Assert.assertTrue(MessageFormat.format("Checking non cache access {0} slower than cached access {1}", new Object[]{nonCacheAccess, cacheAccess}), nonCacheAccess > cacheAccess);
    }

    @Test
    public void testCacheTimer() throws Exception {
        populateCache();
        Assert.assertSame("All entries present in cache", ((ExpiryCacheImpl) cache).getCacheSize(), FULL_CACHE_SIZE);
        Thread.sleep(5000);
        Assert.assertSame("Expired entries flushed from cache", ((ExpiryCacheImpl) cache).getCacheSize(), 0);

    }

    private void populateDataBase() {
        for (char c = 'a'; c <= 'z'; c++) {
            mockDao.putData(Character.toString(c), new String(Character.toString(c) + " : value"));
        }
    }

    private long timeNonCacheAccess() {
        long start = System.currentTimeMillis();
        for (char c = 'a'; c <= 'z'; c++) {
            mockDao.getData(Character.toString(c));
        }
        return System.currentTimeMillis() - start;
    }

    private long timeCachedAccess() {
        populateCache();
        long start = System.currentTimeMillis();
        for (char c = 'a'; c <= 'z'; c++) {
            cache.get(Character.toString(c));
        }
        return System.currentTimeMillis() - start;
    }

    private void populateCache() {
        for (char c = 'a'; c <= 'z'; c++) {
            String currentKey = Character.toString(c);
            cache.put(currentKey, new String(Character.toString(c) + " : value"), 3, TimeUnit.SECONDS);
        }
    }
}
