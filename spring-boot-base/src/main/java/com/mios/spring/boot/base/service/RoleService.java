package com.mios.spring.boot.base.service;

import java.util.List;

import com.mios.spring.boot.base.domain.Role;

/**
 * User Service Interface 
 * 
 * @author jmroldanv
 */
public interface RoleService {

	Role addRole(Role rol); 
	Role getRoleById(Long id);
	Role getRoleByName(String name);
	List<Role> getRoles();
	Role getRoleWithUsersByName(String name);
}
