package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enums.Status;
import com.facade.UserFacade;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("email", request.getParameter("email"));
        RequestDispatcher requestdispatch = request
                .getRequestDispatcher("/ProfileEdit");
        requestdispatch.include(request, response);
    }
}
