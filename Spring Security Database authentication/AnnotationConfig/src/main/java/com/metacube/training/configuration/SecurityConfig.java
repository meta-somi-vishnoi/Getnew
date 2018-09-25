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
    DataSource dataSource;
    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        
      auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance())
        .usersByUsernameQuery(
            "select email, password, enabled from employee where email=?")
        .authoritiesByUsernameQuery(
            "select username, role from user_roles where username=?");
    }   
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
      .antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')").
      antMatchers("/employee/*").access("hasRole('ROLE_EMPLOYEE')")
      .and()
      .formLogin().loginPage("/login").
      loginProcessingUrl("/Login").
      defaultSuccessUrl("/default")
      .usernameParameter("email").passwordParameter("password")
      .failureUrl("/login?error=true")
      .and()
      .logout().logoutUrl("/Logout").logoutSuccessUrl("/login")
      .and()
      .exceptionHandling().accessDeniedPage("/403")
      .and()
      .csrf();
    }
}
