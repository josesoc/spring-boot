package com.mios.spring.boot.base.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@NotEmpty @Email
	private String email;	

	@Column(nullable = false)
	@NotEmpty
	private String name;
	
	@Column(nullable = false)
	@Size(min=8, max=12)
	private String password;

	public User() {
	}

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password=password;
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
}
