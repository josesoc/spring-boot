package com.mios.spring.boot.base.service;

import java.util.List;

import com.mios.spring.boot.base.domain.Role;

/**
 * User Service Interface 
 * 
 * @author jmroldanv
 */
public interface RoleService {

	Role addRol(Role rol); 
	Role getRolById(Long id);
	Role getRolByName(String name);
	List<Role> getRoles();
	Role getRolWithUsersByName(String name);
}
