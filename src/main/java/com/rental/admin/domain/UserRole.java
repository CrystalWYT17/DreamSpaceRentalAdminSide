package com.rental.admin.domain;

/**
 * @author Wutt Yee Tun
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "roleId")
	private Role role;
	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	public UserRole(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
