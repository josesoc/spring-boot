package com.mios.spring.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QueryRepository {
	private static final Logger log = LoggerFactory.getLogger(QueryRepository.class);
	
	public QueryResult findQueryResult() {
		log.debug("findQueryResult");
		try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
		return new QueryResult("datos");
	}
}
