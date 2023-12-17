package com.rental.admin.utility;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {

private static final String SALT = "HIjbcnvmwoeilBmeVXeil";
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoderInSU() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
	
	@Bean
	public static String randomPassword() {
		
		String SALTCHAR = "JOELdiBjdkoxje384748sjedLIElskbSLjiceo3473JD837JDouelxQ2";
		
		StringBuilder salt = new StringBuilder();
		
		Random rand = new Random();
		
		while(salt.length()<18) {
			int index = (int) (rand.nextFloat()*SALTCHAR.length());
			salt.append(SALTCHAR.charAt(index));
		}
		
		String saltString = salt.toString();
		
		return saltString;
		
	}
	
}
