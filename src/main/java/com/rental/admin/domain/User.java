package com.rental.admin.domain;

/**
 * @author Wutt Yee Tun
 */

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rental.admin.domain.security.Authority;
@Entity
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", nullable = false, updatable = false)
	private Long userId;
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String phoneNo;
	private Boolean enabled = true;
	
	@Transient
	private String confirmPassword;
	
	private Integer rent;
	private Integer owned;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRole = new HashSet<UserRole>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)//Eager
	@JsonIgnore
	private List<HouseRenter> houseRenterList;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)//Eager
	@JsonIgnore
	private List<HouseOwner> houseOwnerList; 
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ContractUser> contractUserList;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<BookingUser> bookingUserList;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public List<HouseRenter> getHouseRenterList() {
		return houseRenterList;
	}

	public void setHouseRenterList(List<HouseRenter> houseRenterList) {
		this.houseRenterList = houseRenterList;
	}

	public List<HouseOwner> getHouseOwnerList() {
		return houseOwnerList;
	}

	public void setHouseOwnerList(List<HouseOwner> houseOwnerList) {
		this.houseOwnerList = houseOwnerList;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

	public Integer getOwned() {
		return owned;
	}

	public void setOwned(Integer owned) {
		this.owned = owned;
	}

	public List<ContractUser> getContractUserList() {
		return contractUserList;
	}

	public void setContractUserList(List<ContractUser> contractUserList) {
		this.contractUserList = contractUserList;
	}

	public List<BookingUser> getBookingUserList() {
		return bookingUserList;
	}

	public void setBookingUserList(List<BookingUser> bookingUserList) {
		this.bookingUserList = bookingUserList;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		userRole.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
}
