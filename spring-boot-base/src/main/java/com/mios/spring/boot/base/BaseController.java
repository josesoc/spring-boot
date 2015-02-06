package com.mios.spring.boot.base;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * BaseController for mapping url resources
 * 
 * @author jmr
 *
 */
@Controller
public class BaseController {
 
	static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
    @RequestMapping("/")
    public String home(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        logger.info("home controller mapping");
        return "welcome";
    }
    
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", "data list");
        logger.info("list controller mapping");
        return "list";
    }
}
