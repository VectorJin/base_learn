package com.jinku.learn.cache;

import org.junit.Test;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JCacheDemo {

    @Test
    public void sample() {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();
        MutableConfiguration<Long, List> configuration =
                new MutableConfiguration<Long, List>()
                        .setTypes(Long.class, List.class)
                        .setStoreByValue(true)
                        .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ONE_MINUTE));
        Cache<Long, List> cache = cacheManager.createCache("jCache", configuration);
        List<Integer> list = new ArrayList<>(Arrays.asList(1,3,4));
        cache.put(1L, list);
        List cachedList = cache.get(1L);
        System.out.println(cachedList);
        list.add(5);
        System.out.println(list == cachedList);
        System.out.println(cachedList);
    }
}
