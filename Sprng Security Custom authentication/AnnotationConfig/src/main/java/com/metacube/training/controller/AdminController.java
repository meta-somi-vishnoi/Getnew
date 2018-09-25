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

@Controller
@RequestMapping(value = "/admin")

public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/dashboard") 
    public String dashboard() {
        return "admin/dashboard";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String adminAddEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "admin/addEmployee";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public String adminAddEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee != null && employee.getCode() == 0) {
            System.out.println(employee.getCode());
            Status status = adminService.addEmployee(employee);
        } else {
            Status status = adminService.updateEmployee(employee);
        }
        return "redirect:allEmployees";
    }

    @RequestMapping(path = "/allEmployees", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        if(adminService.getAllEmployees() != null) {
            model.addAttribute("employees", adminService.getAllEmployees());
            return "admin/allEmployees";
        } else {
            String error = "Invalid user or password";
            model.addAttribute("error", error);
            return "admin/allEmployees";
        }
    }

    @RequestMapping(path = "/editEmployee", method = RequestMethod.GET)
    public String editproject(Model model, @RequestParam("code") int code) {
        if(adminService.getEmployeeByCode(code)!=null) {
            model.addAttribute("employee", adminService.getEmployeeByCode(code));
            return "admin/addEmployee";
        } else {
            model.addAttribute("error", "No such employee exist");
            return "admin/dashboard";
        }
    }

    @RequestMapping(path = "/deleteEmployee", method = RequestMethod.GET)
    public String deleteEmployee(Model model, @RequestParam("code") int code) {
        if(adminService.deleteEmployeeByCode(code) != null) {
            model.addAttribute("employee", adminService.deleteEmployeeByCode(code));
            return "redirect:allEmployees";
        } else {
            model.addAttribute("error", "No such employee exist");
            return "admin/dashboard";
        }
    }

    @RequestMapping(value = "/searchEmployees", method = RequestMethod.GET)
    public String searchEmployee() {
        return "admin/searchEmployee";
    }

    @RequestMapping(path = "/searchEmployees", method = RequestMethod.POST)
    public String searchEmployee(Model model, @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName) {
        if(adminService.searchEmployees(firstName, lastName) != null) {
            model.addAttribute("employees", adminService.searchEmployees(firstName, lastName));
            return "admin/allEmployees";
        } else {
            model.addAttribute("error", "No such employee exist");
            return "admin/dashboard";
        }
    }
}
