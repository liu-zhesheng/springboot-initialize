package org.aliu.springboot.model.four.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存管理器配置类
 *
 * @author liusheng
 * @date 2021/9/27
 */
@Slf4j
@EnableCaching
@Configuration
public class CaffeineCacheConfig {

    /**
     * CacheManager实现类
     *
     * @return
     */
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        List<CaffeineCache> caches = new ArrayList<>();

        caches.add(new CaffeineCache("users-cache",
                Caffeine.newBuilder().
                        maximumSize(1000).   //指定Key下的最大缓存数据量
                        expireAfterAccess(120, TimeUnit.SECONDS).  //最后一次访问之后 120 秒过期
                        build()));

        simpleCacheManager.setCaches(caches);
        return simpleCacheManager;
    }
}
