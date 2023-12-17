package com.rental.admin.dao;

import java.util.List;

/**
 * @author Wutt Yee Tun
 */

import org.springframework.data.repository.CrudRepository;

import com.rental.admin.domain.User;


public interface UserDAO extends CrudRepository<User, Long>{

	User findByEmail(String email);
	
	User findByUsername(String username);
	
	List<User> findAll();
	
	User findByFirstName(String firstName);
	
}
