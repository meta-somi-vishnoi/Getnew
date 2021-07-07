package com.metacube.training.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.metacube.training.service.AdminService;

@Controller
@RequestMapping(value = "/employee")
@SessionAttributes("email")
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
    public String adminLoginDetails(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
        Status status = adminService.login(email, password);
        if (status.equals(Status.EXIST)) {
            session.setAttribute("email", email);
            return "employee/dashboard";
        } else {
            String error = "Invalid user or password";
            model.addAttribute("error", error);
            return "employee/login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        session.invalidate();
        return "employee/login";
    }

    @RequestMapping(value = "/dashboard") 
    public String dashboard() {
            return "employee/dashboard";
    }
    
    @RequestMapping(value = "/searchEmployees", method = RequestMethod.GET)
    public String searchEmployee() {
        return "employee/searchEmployeeForm";
    }

    @RequestMapping(path = "/searchEmployees", method = RequestMethod.POST)
    public String searchEmployee(Model model, @RequestParam("skill") String skill) {
        if(adminService.searchEmployees(skill) != null) {
            model.addAttribute("employees", adminService.searchEmployees(skill));
            return "employee/searchEmployeeForm";
        } else {
            model.addAttribute("error", "No such employee exist");
            return "employee/searchEmployeeForm";
        }
    }
    
    @RequestMapping(path = "/viewProfile", method = RequestMethod.GET)
    public String viewEmployeeGet(Model model) {
        String emailId = (String) session.getAttribute("email");
        model.addAttribute("employee", adminService.getEmployeeByEmail(emailId));
        model.addAttribute("employees", adminService.getEmployeeByEmail(emailId));
        return "employee/allEmployees";
    }

    @RequestMapping(path = "/editEmployee", method = RequestMethod.GET)
    public String editEmployee(Model model, @RequestParam("code") int code) {
        model.addAttribute("employee", adminService.getEmployeeByCode(code));
        return "employee/editEmployee";
    }
    
    @RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public String adminAddEmployee(@ModelAttribute("employee") Employee employee) {
        Status status = adminService.updateEmployee(employee);
        return "redirect:viewProfile";
    }
}
