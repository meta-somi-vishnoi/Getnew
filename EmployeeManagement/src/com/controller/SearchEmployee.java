package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enums.Status;
import com.facade.EmployeeFacade;
import com.models.Employee;
import com.models.SearchEmployeeByName;

/**
 * Servlet implementation class SearchEmployee
 */

public class SearchEmployee extends HttpServlet {
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
        SearchEmployeeByName employee = new SearchEmployeeByName(firstName, lastName);
        System.out.println("servlet"+employee.getFirstName());
        ArrayList<Employee> list = employeeFacade.searchEmployee(employee);
        out.println("<html><head> <title>Search Employee</title> </head><body>");
        out.println("<table align = 'center' width = '70%'><tr><td align='left'><img src='images/emp.png' width='10%' /></td>"
            + "<td align='right'><a href='index.html'>Home</a>  ");
        out.println("<a href='AddEmployee.html'>Add Employee</a> <a href='ShowEmployee'>Show Employee</a> "
            + "<a href='SearchEmployee.html'>Search Employee</a></td></tr> "
            + "<tr> <td colspan='2'><hr /></td> </tr> </table><br />");
        if (list.size() == 0) {
            out.println("No users exist");
        } else {
            out.println("<h1>Search Employees</h1>");
            out.println("<table align = 'center' width = '70%'>");
            out.println("<tr><td>First Name</td><td>Last Name</td><td>Email</td><td>Age</td></tr>");
            for (Employee person : list) {
                out.println("<tr><td>" + person.getFirstName() + "</td><td>" + person.getLastName() + "</td><td>"
                    + person.getEmail() + "</td><td>" + person.getAge() + "</td></tr>");
            }
            out.println("</table></body></html>");
        }
    }
}
