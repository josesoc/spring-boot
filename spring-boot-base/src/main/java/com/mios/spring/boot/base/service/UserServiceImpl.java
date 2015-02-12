package com.mios.spring.boot.base.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mios.spring.boot.base.domain.User;
import com.mios.spring.boot.base.repository.UserRepository;

/**
 * User Service Implementation
 * 
 * @author jmroldanv
 */
@Component
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository repository;
	
	@Transactional(readOnly = false)
	@Override
	public User addUser(User user) {
		return this.repository.save(user);
	}
	
	@Transactional(readOnly = true)
	@Override
	public User getUserById(Long id) {
		return this.repository.findById(id); 
	}
	
	@Transactional(readOnly = true)
	@Override
	public User getUserByName(String name) {
		return this.repository.findByName(name);
	}	

	@Transactional(readOnly = true)
	@Override
	public User getUserByEmail(String email) {
		return this.repository.findByEmail(email); 
	}	

	@Transactional(readOnly = true)
	@Override
	public List<User> getUsers() {
		return this.repository.findAll();
	}

	@Transactional(readOnly = false)
	@Override
	public User updateUser(User user) {
		return repository.save(user);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> getUserByNameStartingWith(String namePrefix) {
		return repository.findByNameStartingWith("pe");
	}

	@Transactional(readOnly = false)
	@Override
	public void removeUserById(Long id) {
		repository.delete(id);		
		repository.flush();
	}	
}
