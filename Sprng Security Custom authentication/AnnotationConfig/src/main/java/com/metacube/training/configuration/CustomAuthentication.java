package com.metacube.training.configuration;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.metacube.training.dao.AdminDao;
import com.metacube.training.models.UserRoles;

@Component
public class CustomAuthentication implements AuthenticationProvider{

    @Autowired
    private AdminDao adminDao;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String user = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());
        if(adminDao.getEmployeeByUsername(user, password) == null) {
            throw new BadCredentialsException("User not found");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        List<UserRoles> userRole = adminDao.getRolesOfEmployee(user);
        for (int i = 0; i < userRole.size() ; i++) {
            String role = userRole.get(i).getRole();
            System.out.println(role);
            roles.add(new SimpleGrantedAuthority(role));
        }
        return new UsernamePasswordAuthenticationToken(user, password, roles);
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
