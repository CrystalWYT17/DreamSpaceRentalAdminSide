package com.rental.admin.service.impl;

/**
 * @author Wutt Yee Tun
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rental.admin.dao.UserDAO;
import com.rental.admin.domain.User;


@Service
public class UserSecurityService implements UserDetailsService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userDAO.findByEmail(email);
		
//		if(user == null) {
//			throw new UsernameNotFoundException("Email Not Found");
//		}
		
		return user;
	}

}
