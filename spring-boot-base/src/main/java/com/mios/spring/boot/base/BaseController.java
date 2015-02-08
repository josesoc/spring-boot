package com.mios.spring.boot.base;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.mios.spring.boot.base.domain.User;
import com.mios.spring.boot.base.service.UserService;

/**
 * BaseController for mapping url resources
 * 
 * @author jmroldanv
 *
 */
@Controller
public class BaseController {
 
	static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * Home
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
    @RequestMapping("/")
    public String home(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        logger.info("home controller mapping");
        return "welcome";
    }
    
    /**
     * Get a User by email
     * 
     * @param email
     * @param model
     * @return
     */
    @RequestMapping("/user/{email}")
    public String showUser(@PathVariable("email") String email, Model model) {
    	logger.info("user/"+email+" controller mapping");
    	 
    	User user=userService.getUserByEmail(email);    	
        model.addAttribute("user", user);        
        return "user";
    }
    
    /**
     * List of all users
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/users")
    public String users(Model model) {
    	
    	logger.info("users");
    	
    	List<User> users=this.userService.getUsers();
    	model.addAttribute("users", users);   
        return "users";
    }

    /**
     * Form page to add a User
     * 
     * @param model
     * @return
     */
    @RequestMapping(value="/user/add", method=RequestMethod.GET)
	public String userAdd(Model model) {
    	User user=new User();
    	model.addAttribute("user", user);
		return "userAdd";
	}
    
    /**
     * Adding a User to database
     * 
     * @param user
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value="/user/add", method=RequestMethod.POST)
	public String submitForm(@Valid User user, BindingResult result, Model model) {
		
    	logger.info("/user/add POST Validating form");
    	
    	if(result.hasErrors()) {
			return "userAdd";
		}
    	
    	logger.info("/user/add POST successfully validated form");
		
		userService.addUser(user);
		model.addAttribute("message", "Successfully saved user: " + user.getName());
		
		return "userAdd";
	}
    
    /**
     * Creates a redirect view path.
     * @param requestMapping    The request mapping of target controller method.
     * @return  The created redirect view path.
    
    private String createRedirectViewPath(String requestMapping) {
        StringBuilder redirectViewPath = new StringBuilder();
        redirectViewPath.append("redirect:");
        redirectViewPath.append(requestMapping);
        return redirectViewPath.toString();
    }
     */
}
