package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;
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
import com.metacube.training.services.AdminService;
import com.metacube.training.services.SendEmail;

@Controller
@RequestMapping(value = "/employee")
@SessionAttributes("username")
public class EmployeeController {
    
    @Autowired
    private AdminService adminService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/dashboard") 
    public String dashboard() {
            return "employee/dashboard";
    }
    
    @RequestMapping(value = "/searchEmployees", method = RequestMethod.GET)
    public String searchEmployee() {
        return "admin/searchEmployee";
    }

    @RequestMapping(path = "/searchEmployees", method = RequestMethod.POST)
    public String searchEmployee(Model model, @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName) {
        System.out.print(firstName + " " + lastName);
        if(adminService.searchEmployees(firstName, lastName) != null) {
            model.addAttribute("employees", adminService.searchEmployees(firstName, lastName));
            return "employee/searchEmployee";
        } else {
            model.addAttribute("error", "No such employee exist");
                return "employee/searchEmployeeForm";
        }
    }
    
    @RequestMapping(path = "/viewProfile", method = RequestMethod.GET)
    public String viewEmployeeGet(Model model) {
        String emailId = (String) session.getAttribute("username");
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
    
    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "employee/forgotPassword";
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ModelAndView employeeForgotPassword(@RequestParam("email") String email, @RequestParam("password") 
        String password, @RequestParam("confirmPassword") String confirmPassword) {
        if (password.equals(confirmPassword)) {
            Status status = adminService.updatePassword(email, password);
            if(status.equals(Status.UPDATED)) {
            	SendEmail.SendEmail(email, password);
            	return new ModelAndView("employee/dashboard", "email", email);
            } else {
            	return new ModelAndView("employee/forgetPassword");
            }
        } else {
            String error = "Password mismatches";
            return new ModelAndView("employee/forgotPassword", "error", error);
        }
    }

}
