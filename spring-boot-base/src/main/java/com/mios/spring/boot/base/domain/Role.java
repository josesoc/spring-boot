package com.mios.spring.boot.base.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false, length=30)
	@NotEmpty
	private String name;
	
	/**
	 * El termino Lazy Fetch, que traducido literalmente significa obtención perezosa 
	 * (lectura demorada), viene a reflejar la característica de JPA que permite que, 
	 * cuando existen relaciones entre distintas entidades, las que son dependientes 
	 * de otras no sean inicializadas con sus valores almacenados en base de datos 
	 * hasta que no sean explícitamente accedidas (leidas).
	 * 
	 * The annotation @JoinColumn indicates that this entity is the owner of the relationship 
	 * (that is: the corresponding table has a column with a foreign key to the referenced table), 
	 * whereas the attribute mappedBy indicates that the entity in this side is the inverse of 
	 * the relationship, and the owner resides in the "other" entity.	 * 
	 */
	@OneToMany(mappedBy="role", fetch=FetchType.LAZY)
    private List<User> users;

	public Role() {
	}
	
	public Role(String name) {
		this.name=name;
	}
	
	public Role(Long id) {
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}	
}
