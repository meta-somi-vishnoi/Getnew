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
import com.metacube.training.services.EmailService;
import com.metacube.training.services.ValidateService;

@Controller
@SessionAttributes("email")
@RequestMapping(value = "/employee")
public class EmployeeController {
    
    @Autowired
    private AdminService adminService;
   
    @Autowired
    private EmailService emailService;

    @Autowired
    private ValidateService validateService;
    
    @Autowired
    private HttpSession session;

    @GetMapping("")
    public String adminLogin() {
        return "employee/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String adminLoginDetails(@RequestParam("email") String email, @RequestParam("password") String password, 
            Model model) {
        Status status = adminService.login(email, password);
        System.out.print(status);
        if (status.equals(Status.EXIST)) {
            session.setAttribute("email", email);
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "employee/dashboard";
            } else {
                return "employee/login";
            }           
        } else {
            String error = "Invalid user or password";
            model.addAttribute("error","Invalid username or password");
            return "employee/login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        session.invalidate();
        return "employee/login";
    }

    @RequestMapping(value = "/searchEmployees", method = RequestMethod.GET)
    public String searchEmployee() {
        if(validateService.validateSession(session).equals(Status.EXIST)){
            return "employee/searchEmployeeForm";
        } else {
            return "employee/login";
        }
    }

    @RequestMapping(path = "/searchEmployees", method = RequestMethod.POST)
    public String searchEmployee(Model model, @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName) {
        if(adminService.searchEmployees(firstName, lastName) != null) {
            model.addAttribute("employees", adminService.searchEmployees(firstName, lastName));
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "employee/searchEmployee";
            } else {
                return "employee/login";
            }
        } else {
            model.addAttribute("error", "No such employee exist");
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "employee/dashboard";
            } else {
                return "employee/login";
            }
        }
    }
    
    @RequestMapping(path = "/viewProfile", method = RequestMethod.GET)
    public String viewEmployeeGet(Model model) {
        String emailId = (String) session.getAttribute("email");
        model.addAttribute("employees", adminService.getEmployeeByEmail(emailId));
        if(validateService.validateSession(session).equals(Status.EXIST)){
            return "employee/searchEmployee";
        } else {
            return "employee/login";
        }
    }

    @RequestMapping(path = "/editEmployee", method = RequestMethod.GET)
    public String editEmployee(Model model, @RequestParam("code") int code) {
        model.addAttribute("employee", adminService.getEmployeeByCode(code));
        if(validateService.validateSession(session).equals(Status.EXIST)){
            return "employee/editEmployee";
        } else {
            return "employee/login";
        }
    }
    
    @RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public String adminAddEmployee(@ModelAttribute("employee") Employee employee) {
        Status status = adminService.updateEmployee(employee);
        return "redirect:allEmployees";
    }
    
    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        if(validateService.validateSession(session).equals(Status.EXIST)){
            return "employee/forgotPassword";
        } else {
            return "employee/login";
        }
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public String employeeForgotPassword(@RequestParam("email") String email, @RequestParam("password") 
        String password, @RequestParam("confirmPassword") String confirmPassword, Model model) {
        if (password.equals(confirmPassword)) {
            Status status = adminService.updatePassword(email, password);
            if(status.equals(Status.UPDATED)) {
            	emailService.sendEmail(email, password);
            	model.addAttribute("email", email);
            	return "employee/dashboard";
            } else {
            	return "employee/forgetPassword";
            }
        } else {
            String error = "Password mismatches";
            model.addAttribute("error", error);
            return "employee/forgotPassword";
        }
    }
}
