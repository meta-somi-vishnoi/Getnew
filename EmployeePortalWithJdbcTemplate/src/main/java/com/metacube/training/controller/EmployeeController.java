package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;
import com.metacube.training.services.AdminService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    
    @Autowired
    private AdminService adminService;

    @Autowired
    private HttpSession session;

    @GetMapping("")
    public String adminLogin() {
        return "employee/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView adminLoginDetails(@RequestParam("email") String email, @RequestParam("password") String password) {
        Status status = adminService.login(email, password);
        System.out.print(status);
        if (status.equals(Status.EXIST)) {
            session.setAttribute("email", email);
            return new ModelAndView("employee/dashboard", "email", email);
        } else {
            String error = "Invalid user or password";
            return new ModelAndView("employee/login", "error", error);
        }
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        session.invalidate();
        return "employee/login";
    }

    @RequestMapping(value = "/searchEmployees", method = RequestMethod.GET)
    public String searchEmployee() {
        return "admin/searchEmployee";
    }

    @RequestMapping(path = "/searchEmployees", method = RequestMethod.POST)
    public String searchEmployee(Model model, @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName) {
        model.addAttribute("employees", adminService.searchEmployees(firstName, lastName));
        return "employee/allEmployees";
    }

    @RequestMapping(path = "/viewProfile", method = RequestMethod.POST)
    public String viewEmployee(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String emailId = (String) session.getAttribute("email");
        model.addAttribute("employee", adminService.getEmployeeByEmail(emailId));
        return "employee/editEmployee";
    }

    @RequestMapping(path = "/editEmployee", method = RequestMethod.POST)
    public String editEmployee(Model model, @RequestParam("code") int code) {
        model.addAttribute("employees", adminService.getEmployeeByCode(code));
        return "admin/addEmployee";
    }
}
