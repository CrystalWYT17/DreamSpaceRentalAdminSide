package com.rental.admin.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wutt Yee Tun
 */

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId; 
	
	private String name;
	
	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	
}
