package com.metacube.training.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {		
		auth.inMemoryAuthentication().withUser("admin@gmail.com").password("{noop}123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("somi123@gmail.com").password("{noop}123456").roles("EMPLOYEE");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests().
	    antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')").
	    antMatchers("/employee/*").access("hasRole('ROLE_EMPLOYEE')").
	    and().formLogin().  //login configuration
	    loginPage("/login").
	    loginProcessingUrl("/Login").
	    defaultSuccessUrl("/default").  
	    failureUrl("/login?error=true").
	    and().logout().logoutUrl("/Logout")//logout configuration
	    .logoutSuccessUrl("/login") ;
	}
}
