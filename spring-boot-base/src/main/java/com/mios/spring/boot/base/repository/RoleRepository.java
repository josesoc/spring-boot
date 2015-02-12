package com.mios.spring.boot.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mios.spring.boot.base.domain.Role;

/**
 * jpaRepository provide default methods: 
 * 	  findAll()
 *    findAll(Sort)
 *    save(T)
 *    ...  
 * 
 * @author jmroldanv
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findById(Long id);
	Role findByName(String name);
}
