package com.mios.spring.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    /**
     * Cache implementation (It would be ehcache, memcache, ...)
     * 
     * @return
     */
    @Bean
    public CacheManager cacheManager() {
    	/*
    	 * Se le pueden pasar varios nombres de caches:
    	 *     new ConcurrentMapCacheManager("queries", "pages")
    	 */
        return new ConcurrentMapCacheManager("queries");
    }
}