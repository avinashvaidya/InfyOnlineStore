/**
 * 
 */
package com.infy.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author AvinashVaidya
 *
 */
@Configuration
@EnableCaching
public class InfyOnlineStoreCacheConf {

	@Bean(name = "ehcacheManagerBean")
	public EhCacheManagerFactoryBean getEhcacheManager() {

		EhCacheManagerFactoryBean ehchacheManager = new EhCacheManagerFactoryBean();
		ehchacheManager.setConfigLocation(new ClassPathResource("/com/infy/properties/ehcache.xml"));
		return ehchacheManager;
	}

	@Bean(name = "cacheManager")
	public EhCacheCacheManager getCacheManager() {
		EhCacheCacheManager cacheManager = new EhCacheCacheManager();
		cacheManager.setCacheManager(getEhcacheManager().getObject());
		return cacheManager;
	}

}
