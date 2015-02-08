package com.mios.spring.boot.base.service;

import java.util.List;

import com.mios.spring.boot.base.domain.User;

/**
 * User Service Interface 
 * 
 * @author jmroldanv
 */
public interface UserService {

	User addUser(User user); 
	User getUserById(Long id);
	User getUserByName(String name);	
	User getUserByEmail(String email);
	List<User> getUsers();
	
}
