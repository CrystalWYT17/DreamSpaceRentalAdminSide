package com.rental.admin;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rental.admin.domain.Role;
import com.rental.admin.domain.User;
import com.rental.admin.domain.UserRole;
import com.rental.admin.service.UserService;
import com.rental.admin.utility.SecurityUtility;

@SpringBootApplication
public class DreamSpaceRentalAdminSideApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(DreamSpaceRentalAdminSideApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.setFirstName("Fery");
		user.setLastName("Kott");
		user.setUsername("Garry");
		user.setEmail("dreamspacerental@gmail.com");
		user.setPhoneNo("+959776583299");
		
		user.setPassword(SecurityUtility.passwordEncoderInSU().encode("admin"));
		
		System.out.println(user);
		
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_ADMIN");
		
		Role role1 = new Role();
		role1.setRoleId(2);
		role1.setName("ROLE_USER");
		
		Set<UserRole>  userRole = new HashSet<>();
		userRole.add(new UserRole(user,role));
		userRole.add(new UserRole(user,role1));
		
		//user.setUserRole(userRole);
		userService.createUser(user, userRole);
		
	}

}
