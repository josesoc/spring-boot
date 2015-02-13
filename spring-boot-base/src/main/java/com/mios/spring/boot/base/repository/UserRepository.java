package com.mios.spring.boot.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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
public interface UserRepository extends JpaRepository<User, Long>, 
									    JpaSpecificationExecutor<User> {
	
	User findById(Long id);
	User findByName(String name);
	User findByEmail(String email);
	List<User> findByNameStartingWith(String namePrefix);
}
