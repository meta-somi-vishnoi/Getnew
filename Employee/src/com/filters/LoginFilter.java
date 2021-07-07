package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.enums.Status;
import com.facade.UserFacade;
import com.models.UserDetails;

public class LoginFilter implements Filter {

    private UserFacade userFacade = UserFacade.getInstance();
    private UserDetails userDetails = new UserDetails();

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        userDetails.setEmail(request.getParameter("email"));
        userDetails.setPassword(request.getParameter("password"));
        Status status = userFacade.validateUserDetails(userDetails);
        if (Status.FOUND.equals(status)) {
            chain.doFilter(request, response);
        } else {
            out.println("!!User not Registered!!");
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

}
