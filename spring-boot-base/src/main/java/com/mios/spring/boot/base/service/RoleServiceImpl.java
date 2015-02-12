package com.mios.spring.boot.base.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.mios.spring.boot.base.domain.Role;
import com.mios.spring.boot.base.repository.RoleRepository;

@Component
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleRepository repository;
	
	@Transactional(readOnly = false)
	@Override
	public Role addRol(Role rol) {
		return repository.save(rol); 
	}

	@Transactional(readOnly = true)
	@Override
	public Role getRolById(Long id) {
		return repository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Role getRolByName(String name) {
		return repository.findByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Role> getRoles() {
		return repository.findAll();
	}	
	
	@Transactional(readOnly = true)
	@Override
	public Role getRolWithUsersByName(String name) {
		Role role=repository.findByName(name);
		//Init List (to avoid LazyLoading Exception)
		role.getUsers().size();
		return role;
	}
}
