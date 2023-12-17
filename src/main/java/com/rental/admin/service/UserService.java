package com.rental.admin.service;

/**
 * @author Wutt Yee Tun
 */


import java.util.List;
import java.util.Set;
import com.rental.admin.domain.User;
import com.rental.admin.domain.UserRole;

public interface UserService {
	
	User findByEmail(String email);
	
	User findByUsername(String username);
	
	User createUser(User user,Set<UserRole>  userRoles);
	
	User updateUser(User user);
	
	User saveUser(User user);
	
	List<User> findAll();
	
	void removeOne(Long userId);
	
	User findById(Long userId);
	
	User findByFirstName(String firstName);

}
