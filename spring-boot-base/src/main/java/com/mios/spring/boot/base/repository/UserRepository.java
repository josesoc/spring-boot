package com.mios.spring.boot.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mios.spring.boot.base.domain.User;

/**
 * jpaRepository provide default methods: 
 * 	  findAll()
 *    findAll(Sort)
 *    save(T)
 *    ...  
 * 
 * @author jmroldanv
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(Long id);
	User findByName(String name);
	User findByEmail(String email);	
}
