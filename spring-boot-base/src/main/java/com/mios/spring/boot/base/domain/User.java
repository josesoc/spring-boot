package com.mios.spring.boot.base.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User entity with Validation annotations
 * 
 * @author jmroldanv
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(length=40)
	@NotEmpty @Email
	private String email;	

	@Column(nullable = false, length=30)
	@NotEmpty
	private String name;
	
	@Column(nullable = false, length=12)
	@Size(min=8, max=12)
	private String password;
	
    @ManyToOne
	  @JoinColumn(name="role_id", referencedColumnName="id")
	    // NOTA: mediante el joinColumn explicitamos que el nombre de la FK de 
	    //       esta tabla (users) se llamara rol_id y la PK de la tabla Roles 
	    //       a la cual hara referencia esta FK se llama id.          
	private Role role;
    
    private int age;

	public User() {
	}

	public User(String email, String name, String password, Role rol) {
		this.email = email;
		this.name = name;
		this.password=password;
		this.role = rol;
	}
	
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role rol) {
		this.role = rol;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	
}
