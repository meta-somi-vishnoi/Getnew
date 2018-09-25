package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private CustomAuthentication authProvider;
 
    @Override
    protected void configure(
      AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
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
      usernameParameter("email").passwordParameter("password").
      failureUrl("/login?error=true").
      and().logout().logoutUrl("/Logout") //logout configuration
      .logoutSuccessUrl("/login");
  }
}
