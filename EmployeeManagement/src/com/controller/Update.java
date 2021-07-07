package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facade.EmployeeFacade;
import com.models.Employee;

/**
 * Servlet implementation class Update
 */

public class Update extends HttpServlet {
    EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(request.getParameter("id"));
        Employee employee = employeeFacade.updateEmployee(id);
        out.println("<html><head> <title>Update Employee</title> </head><body>");
        out.println("<table align = 'center' width = '70%'><tr><td align='left'><img src='images/emp.png' width='10%' />"
            + "</td><td align='right'><a href='index.html'>Home</a>  ");
        out.println("<a href='AddEmployee.html'>Add Employee</a> <a href='ShowEmployee'>Show Employee</a> "
            + "<a href='SearchEmployee.html'>Search Employee</a></td></tr> "
            + "<tr> <td colspan='2'><hr /></td> </tr> </table><br />");
        out.println("<form action = 'UpdateEmployee' method='get'>");
        out.println("<table width = '50%' align = 'center'>");
        out.println("<tr><td>Employee Id</td><td><input type='hidden' name='id' value=" + employee.getId() + " /></td></tr>");
        out.println("<tr><td>First Name</td><td><input type = 'text' name = 'firstName' value = '" + employee.getFirstName()
            + "' /></td></tr>");
        out.println("<tr><td>last Name</td><td><input type = 'text' name = 'lastName' value = '" + employee.getLastName()
            + "' /></td></tr>");
        out.println("<tr><td>Email</td><td><input type = 'text' name = 'email' value = '" + employee.getEmail()
            + "' /></td></tr>");
        out.println("<tr><td>Age</td><td><input type = 'text' name = 'age' value = '" + employee.getAge()
            + "' /></td></tr></table>");        
        out.println("<center><input type = 'submit' name= 'submit' value = 'Submit' /><center>");
        out.println("</form></body></html>");
    }
}
