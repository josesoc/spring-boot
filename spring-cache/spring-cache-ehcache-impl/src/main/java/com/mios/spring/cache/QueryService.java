package com.mios.spring.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class QueryService {
	private static final Logger log = LoggerFactory.getLogger(QueryService.class);
	
	 @Autowired
	 private QueryRepository repository; 
	
	 @Cacheable("queries")
	 public QueryResult getQueryResult() {
		 log.debug("getQueryResult");
	     return repository.findQueryResult();
	 }
	 
	 /**
	  * Flushing multiple caches
	  * 
	 @Caching(evict = {
				@CacheEvict(value="queries", allEntries=true),
				@CacheEvict(value="podcasts", allEntries=true),
				@CacheEvict(value="searchResults", allEntries=true),
				@CacheEvict(value="newestAndRecommendedPodcasts", allEntries=true),
				@CacheEvict(value="randomAndTopRatedPodcasts", allEntries=true)		    
	 })	
	 **/
	 @CacheEvict(value="queries", allEntries=true)
	 public void flushAllCaches() {
		 log.info("All caches have been completely flushed");
	 }

}
