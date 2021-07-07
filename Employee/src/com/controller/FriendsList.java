package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facade.UserFacade;
import com.models.UserDetails;

/**
 * Servlet implementation class FriendsList
 */
public class FriendsList extends HttpServlet {
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        UserFacade userFacade = UserFacade.getInstance();
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList = userFacade.selectListOfFriends((String) request
                .getSession().getAttribute("email"));
        request.setAttribute("userDetailsList", userDetailsList);
        RequestDispatcher view = request.getRequestDispatcher("/friends.jsp");
        view.forward(request, response);
    }

}
