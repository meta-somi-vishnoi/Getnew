package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enums.Status;
import com.facade.UserFacade;
import com.models.UserDetails;
import com.oreilly.servlet.MultipartRequest;

public class UploadImage extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        UserDetails userDetails = new UserDetails();
        UserFacade userFacade = UserFacade.getInstance();
        PrintWriter out = response.getWriter();
        MultipartRequest multipartRequest = new MultipartRequest(request,
                "C:\\Users\\user39\\workspace\\Employee\\WebContent\\images");
        Enumeration files = multipartRequest.getFileNames();
        String fileName = null;
        while (files.hasMoreElements()) {
            String name = (String) files.nextElement();
            fileName = multipartRequest.getFilesystemName(name);
        }
        userDetails.setEmail((String) request.getSession()
                .getAttribute("email"));
        userDetails.setImage(fileName);
        Status status = userFacade.uploadImage(userDetails);
        if (Status.UPDATED.equals(status)) {
            userDetails = userFacade.selectUserDetailsByEmail((String) request
                    .getSession().getAttribute("email"));
            request.setAttribute("userDetails", userDetails);
            RequestDispatcher view = request
                    .getRequestDispatcher("/profile.jsp");
            view.forward(request, response);
        } else {
            out.println(status);
        }
    }
}
