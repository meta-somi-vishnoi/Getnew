package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.UserFacade;
import com.models.UserDetails;

public class ProfileEdit extends HttpServlet {

    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        UserFacade userFacade = UserFacade.getInstance();
        UserDetails userDetails = new UserDetails();
        userDetails = userFacade.selectUserDetailsByEmail((String) request
                .getSession().getAttribute("email"));
        request.setAttribute("userDetails", userDetails);
        RequestDispatcher view = request.getRequestDispatcher("/profile.jsp");
        view.forward(request, response);
    }
}
