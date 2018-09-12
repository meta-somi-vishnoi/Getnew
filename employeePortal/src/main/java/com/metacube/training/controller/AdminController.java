package com.metacube.training.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.metacube.training.services.ValidateService;

@Controller
@RequestMapping(value = "/admin")
@SessionAttributes("email")
public class AdminController {

    @Autowired
    private HttpSession session;

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private ValidateService validateService;

    @GetMapping("")
    public String adminLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String adminLoginDetails(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
        Status status = adminService.login(email, password);
        if (status.equals(Status.EXIST)) {
            session.setAttribute("email", email);
            model.addAttribute("email", email);
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "admin/dashboard";
            } else {
                return "admin/login";
            }
        } else {
            String error = "Invalid user or password";
            model.addAttribute("error", error);
            return "admin/login";
        }
    }

    @RequestMapping(value = "/dashboard") 
    public String dashboard() {
        session.invalidate();
        if(validateService.validateSession(session).equals(Status.EXIST)){
            return "admin/dashboard";
        } else {
            return "admin/login";
        }
    }
    
    @RequestMapping(value = "/logout")
    public String logout() {
        session.invalidate();
        return "admin/login";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String adminAddEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "admin/addEmployee";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public String adminAddEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        if (employee != null && employee.getCode() == 0) {
            if(validateService.validateAddEmployee(employee).equals(Status.NOT_EXIST)) {
                adminService.addEmployee(employee);
            } else {
                if(validateService.validateSession(session).equals(Status.EXIST)){
                String error = "User already exist";
                model.addAttribute("error", error);
                return "admin/addEmployee";
                } else {
                    return "admin/login";
                }
            }
        } else {
            if(validateService.validateAddEmployee(employee).equals(Status.EXIST)) {
                adminService.updateEmployee(employee);
            } else {
                String error = "User not exist";
                model.addAttribute("error", error);
                if(validateService.validateSession(session).equals(Status.EXIST)){
                    return "admin/dashboard";
                } else {
                    return "admin/login";
                }
            }
        }
        return "redirect:allEmployees";
    }

    @RequestMapping(path = "/allEmployees", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        if(adminService.getAllEmployees() != null) {
            model.addAttribute("employees", adminService.getAllEmployees());
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "admin/allEmployees";
            } else {
                return "admin/login";
            }        
        } else {
            String error = "Invalid user or password";
            model.addAttribute("error", error);
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "admin/allEmployees";
            } else {
                return "admin/login";
            }  
        }
    }

    @RequestMapping(path = "/editEmployee", method = RequestMethod.GET)
    public String editproject(Model model, @RequestParam("code") int code) {
        if(adminService.getEmployeeByCode(code)!=null) {
            model.addAttribute("employee", adminService.getEmployeeByCode(code));
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "admin/addEmployee";
            } else {
                return "admin/login";
            }
        } else {
            model.addAttribute("error", "No such employee exist");
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "admin/dashboard";
            } else {
                return "admin/login";
            }
        }
    }

    @RequestMapping(path = "/deleteEmployee", method = RequestMethod.GET)
    public String deleteEmployee(Model model, @RequestParam("code") int code) {
        if(adminService.deleteEmployeeByCode(code) != null) {
            model.addAttribute("employee", adminService.deleteEmployeeByCode(code));
            return "redirect:allEmployees";
        } else {
            model.addAttribute("error", "No such employee exist");
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "admin/dashboard";
            } else {
                return "admin/login";
            }
        }
    }

    @RequestMapping(value = "/searchEmployees", method = RequestMethod.GET)
    public String searchEmployee() {
        if(validateService.validateSession(session).equals(Status.EXIST)){
            return "admin/searchEmployee";
        } else {
            return "admin/login";
        }
    }

    @RequestMapping(path = "/searchEmployees", method = RequestMethod.POST)
    public String searchEmployee(Model model, @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName) {
        if(adminService.searchEmployees(firstName, lastName) != null) {
            model.addAttribute("employees", adminService.searchEmployees(firstName, lastName));
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "admin/allEmployees";
            } else {
                return "admin/login";
            }          
        } else {
            model.addAttribute("error", "No such employee exist");
            if(validateService.validateSession(session).equals(Status.EXIST)){
                return "admin/dashboard";
            } else {
                return "admin/login";
            }
        }
    }
}