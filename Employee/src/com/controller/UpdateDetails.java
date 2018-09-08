package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enums.Status;
import com.facade.UserFacade;
import com.models.UserDetails;

/**
 * Servlet implementation class UpdateDetails
 */
public class UpdateDetails extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        UserDetails userDetails = new UserDetails();
        UserFacade userFacade = UserFacade.getInstance();
        PrintWriter out = response.getWriter();
        userDetails.setFirstName(request.getParameter("first_name"));
        userDetails.setLastName(request.getParameter("last_name"));
        userDetails.setEmail(request.getParameter("email"));
        userDetails.setContactNo(request.getParameter("contact_no"));
        userDetails.setOrganization(request.getParameter("organization"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String parameter = request.getParameter("dob");
        try {
            userDetails
                    .setDob(new java.sql.Date(sdf.parse(parameter).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Status status = userFacade.updateUserDetails(userDetails);
        if (Status.UPDATED.equals(status)) {
            userDetails = userFacade.selectUserDetailsByEmail((String) request
                    .getSession().getAttribute("email"));
            request.setAttribute("userDetails", userDetails);
            RequestDispatcher requestdispatch = request
                    .getRequestDispatcher("/profile.jsp");
            requestdispatch.include(request, response);
        } else {
            out.println(status);
        }
    }
}