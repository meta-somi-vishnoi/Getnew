package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enums.Status;
import com.facade.EmployeeFacade;
import com.models.Employee;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
    
    EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	// TODO Auto-generated method stub
	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        Employee employee = new Employee(0,firstName, lastName, email, age);
        Status status = employeeFacade.updateEmployeeDetails(employee,id);
        if(status.equals(Status.UPDATED)) {
            out.println("Employee updated successfully");
        } else {
            out.println("Employee not updated");
        }
    }
}
