package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Employee;
import com.facade.EmployeeFacade;
import com.enums.Status;

/**
 * Servlet implementation class AddEmployee
 */

public class AddEmployee extends HttpServlet {
    EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
    IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        Employee employee = new Employee(firstName, lastName, email, age);
        Status status = employeeFacade.addEmployee(employee);
        if (status.equals(Status.INSERTED)) {
            out.println("Employee inserted successfully");
        } else {
            out.println("Employee not Inserted");
        }
    }
}
