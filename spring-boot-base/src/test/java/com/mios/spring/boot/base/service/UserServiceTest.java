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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mios.spring.boot.base.DefaultConfig;
import com.mios.spring.boot.base.domain.Role;
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
	
	@Autowired
	private RoleService rolService;
	
	/**
	 * Utility for adding a new Rol
     *
	 * @param name
	 */
    private void addRol(String name) {
    	Role rol=new Role(name);
    	
    	rol=rolService.addRol(rol);
    	
    	assertNotNull(rol);
    	assertNotNull(rol.getName());
    	assertTrue(rol.getName().length() > 0);
    }
	
	/**
	 * Utility for adding a new User
	 * 
	 * @param email
	 * @param name
	 * @param pepepass
	 */
    private void add(String email, String name, String pepepass, int age, Role role) {
    	User user=new User(email, name, pepepass, age, role);
    	
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
    	
    	addRol("user");
        addRol("admin");
        
        add("pepe@gmail.com", "pepe", "pepepass", 10, new Role(1L));
        add("lolo@gmail.com", "lolo", "lolopass", 14, new Role(2L));
        add("luigi@yahoo.com", "luigi", "luigipass", 8, new Role(1L));
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
    	assertNotNull(user.getRole());
    	assertNotNull(user.getRole().getName());
    	assertTrue(user.getRole().getName().equals("user"));
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
        assertTrue(users.size() == 3);
    }   
    
    /**
     * Get a Role by name
     */
    @Test
    public void findRoleByName() {
    	Role rol=rolService.getRolByName("admin");
    	
    	assertNotNull(rol);
    	assertNotNull(rol.getName());
    	assertTrue(rol.getName().equals("admin"));
    }
    
    @Test
    public void findRoleWithUsersByName() {
    	Role role=rolService.getRolWithUsersByName("admin");
    	
    	assertNotNull(role);
    	assertNotNull(role.getName());
    	assertTrue(role.getName().equals("admin"));
    	assertNotNull(role.getUsers());
    	assertTrue(role.getUsers().size() > 0);
    	assertNotNull(role.getUsers().get(0).getEmail());
    	assertTrue(role.getUsers().get(0).getEmail().equals("lolo@gmail.com"));
    }
    
    @Test
    public void findByNameStartingWith() {
    	 List<User> users=service.getUserByNameStartingWith("pe");
    	 
    	 assertNotNull(users);
    	 assertTrue(users.size() > 0);
    	 assertTrue(users.get(0).getName().startsWith("pe"));
    }
    
    @Test
    public void removeUser() {
    	service.removeUserById(1L);
    	
    	User user=service.getUserById(1L);
    	assertTrue(user == null);
    }
    
    /**
     * Update User
     */
    @Test
    public void updateUser() {  
    	//get User
        User user=service.getUserByName("lolo");    	
        assertNotNull(user);        
        user.setPassword("cambiada");
        service.updateUser(user);
        
        //update User
        User user2=service.getUserByName("lolo"); 
        assertTrue(user2.getPassword().equals("cambiada"));
    } 
    
    /**
     * Search Users with eamil and age patterns
     * 
     * Return Users that accomplish the next pattern: 
     *   His email contains "gmail" or "yahoo" as email domain
     *   and his age is greater than 10 years old
     */
    @Test
    public void search() {
    	List<User> users=service.search("%gmail%", "%yahoo%", 10);
    	assertNotNull(users);
    	assertTrue(users.size() == 1);
    	assertTrue(users.get(0).getName().equals("lolo"));
    }
}
