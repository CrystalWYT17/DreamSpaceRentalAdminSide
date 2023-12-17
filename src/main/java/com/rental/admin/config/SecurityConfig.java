package com.rental.admin.config;

/**
 * @author Wutt Yee Tun
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.rental.admin.service.impl.UserSecurityService;
import com.rental.admin.utility.SecurityUtility;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserSecurityService userSecurityService;
	
	private BCryptPasswordEncoder passwordEncoderInSC() {
		return SecurityUtility.passwordEncoderInSU();
	}
	
	
	
	private static final String[] PUBLIC_MATCHERS = {
			"/css/**",
			"/js/**",
			"/images/**",
			"/fonts/**",
			"/scss/**",
			"/vendor/**",
			"/login"
			
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();
		
		http.csrf().disable().cors().disable()
		.formLogin().usernameParameter("email").failureUrl("/login?error")
		.defaultSuccessUrl("/")
		.loginPage("/login").permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
		.and()
		.rememberMe();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoderInSC());
	}
	
}
