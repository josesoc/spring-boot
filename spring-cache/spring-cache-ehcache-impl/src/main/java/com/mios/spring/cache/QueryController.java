package com.mios.spring.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/query")
public class QueryController {
	private static final Logger log = LoggerFactory.getLogger(QueryController.class);

	@Autowired
    private QueryService service;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public void getData() {
    	log.info("getData");
        long start = System.currentTimeMillis();
        QueryResult result = service.getQueryResult();
        long elapsed = System.currentTimeMillis() - start;
        log.info("Controller/getData "+result.getDatos()+"   Time="+elapsed);
    }
    
    @RequestMapping(value = "/flush", method = RequestMethod.GET)
    public void flushData() {
    	log.info("flushData");
    	service.flushAllCaches();  
    }
}
