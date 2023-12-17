package com.rental.admin.utility;

/**
 * @author ThetHninSu
 */

import java.util.Locale;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailConstructor {

	@Autowired
	private Environment env;
	
	public SimpleMailMessage constructSignUpEmail(String contextPath,Locale locale,String cusEmail,String subject) {
		
		String message = "\nWelcome To Our Website.\n Check out for your dream house. Make sure visit!!";
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(cusEmail);
		email.setFrom(env.getProperty("support.email"));
		email.setSubject(subject);
		email.setText(message);
		return email;
	}
	
	public SimpleMailMessage constructApproveEmail(Locale locale,String cusEmail,String subject) {
		
		String message = "\nYour request to Book the house is approved";
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(cusEmail);
		email.setFrom(env.getProperty("support.email"));
		email.setSubject(subject);
		email.setText(message);
		return email;
	}
}
