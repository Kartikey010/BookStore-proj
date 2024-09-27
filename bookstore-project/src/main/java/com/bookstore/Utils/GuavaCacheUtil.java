package com.bookstore.Utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class GuavaCacheUtil {
    private static final Cache<Long, Object> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();

    public static void put(Long key, Object value) {
        cache.put(key, value);
    }

    public static Object get(Long key) {
        return cache.getIfPresent(key);
    }

    // Method to return all cached values
    public static Collection<Object> getAllCacheValues() {
        return cache.asMap().values();
    }
}
