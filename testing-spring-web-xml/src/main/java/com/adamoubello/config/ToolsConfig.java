/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.adamoubello.config;

import com.adamoubello.util.CallMonitoringAspect;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;


@Configuration
@EnableCaching // enables scanning for @Cacheable annotation
@EnableMBeanExport
@EnableAspectJAutoProxy
public class ToolsConfig {
	
	@Bean
    @Description("Call monitoring aspect that monitors call count and call invocation time")
	public CallMonitoringAspect callMonitor() {
		return new CallMonitoringAspect();
	}
	
	@Bean
	@Autowired
	public EhCacheCacheManager ehCacheCacheManager(CacheManager cacheManager) {
		EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
		ehCacheCacheManager.setCacheManager(cacheManager);
		return ehCacheCacheManager;
	}

	@Bean
	public EhCacheManagerFactoryBean cacheManager() {
		EhCacheManagerFactoryBean ehCacheManager = new EhCacheManagerFactoryBean();
		ehCacheManager.setConfigLocation(new ClassPathResource("cache/ehcache.xml"));
		return ehCacheManager;
	}
}
