package com.mios.spring.boot.base.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mios.spring.boot.base.DefaultConfig;
import com.mios.spring.boot.base.domain.User;

/**
 * User Service Unit Tests
 * 
 * @author jmroldanv
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DefaultConfig.class ,loader = SpringApplicationContextLoader.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {	
	
	@Autowired
	private UserService service;

	/**
	 * Utility for adding a new User
	 * 
	 * @param email
	 * @param name
	 * @param pepepass
	 */
    private void add(String email, String name, String pepepass) {
    	User user=new User(email, name, pepepass);
    	
    	user=service.addUser(user);
    	
    	assertNotNull(user);
    	assertNotNull(user.getEmail());
    	assertTrue(user.getEmail().length() > 0);
    }
    
    /**
     * Initial loading of sample Users
     */
    @Test
    public void add() {
    	add("pepe@gmail.com", "pepe", "pepepass");
        add("lolo@gmail.com", "lolo", "lolopass");
    }
    
    /**
     * Get a User by Id
     * 
     * Replacing the default getOne(ID) method that JpaRepository give us because
     * throws a org.hibernate.LazyInitializationException (¡ looking for the reason !)
     * 
     *** Falla si no existe la clave primaria. 
     *   El problema es que en una base de datos real (mysql) si borramos registros
     *   las claves AUTO_INCREMENT se pierden a no ser que se resetee la tabla:
     *   	ALTER TABLE users AUTO_INCREMENT = 1;
     *
    @Test
    public void findById() {
    	User user=service.getUserById(2L);
    	
    	assertNotNull(user);
    	assertNotNull(user.getEmail());
    	assertTrue(user.getEmail().equals("lolo@gmail.com"));
    }
     */
    
    /**
     * Get a User by name
     */
    @Test
    public void findByName() {
    	User user=service.getUserByName("pepe");
    	
    	assertNotNull(user);
    	assertNotNull(user.getName());
    	assertTrue(user.getName().equals("pepe"));
    }
    
    /**
     * Get a User by email
     */
    @Test
    public void findByEmail() {
    	User user=service.getUserByEmail("lolo@gmail.com");
    	
    	assertNotNull(user);
    	assertNotNull(user.getEmail());
    	assertTrue(user.getEmail().equals("lolo@gmail.com"));
    } 
    
    /**
     * Get all users
     */
    @Test
    public void findAll() {        
        List<User> users = service.getUsers();
    	
        assertNotNull(users);
        assertTrue(users.size() > 0);
        assertTrue(users.size() == 2);
    } 
    
}
