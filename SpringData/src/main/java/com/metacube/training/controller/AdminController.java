package com.metacube.training.controller;

import java.util.List;

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
import com.metacube.training.models.Project;
import com.metacube.training.models.Skills;
import com.metacube.training.service.AdminService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillsService;

@Controller
@RequestMapping(value = "/admin")
@SessionAttributes("email")
public class AdminController {

    @Autowired
    private HttpSession session;

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private SkillsService skillService;

    @GetMapping("")
    public String adminLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String adminLoginDetails(Model model, @RequestParam("email") String email, @RequestParam("password") 
    String password) {
        Status status = adminService.login(email, password);
        if (status.equals(Status.EXIST)) {
            session.setAttribute("email", email);
            return "admin/dashboard";
        } else {
            String error = "Invalid user or password";
            model.addAttribute("error", error);
            return "admin/login";
        }
    }

    @RequestMapping(value = "/dashboard") 
    public String dashboard() {
        session.invalidate();
        return "admin/dashboard";
    }
    
    @RequestMapping(value = "/logout")
    public String logout() {
        session.invalidate();
        return "admin/login";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String adminAddEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        List<Skills> list = skillService.getAllSkills();
        model.addAttribute("skillList", list);
        return "admin/addEmployee";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public String adminAddEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee != null && employee.getCode() == 0) {
            adminService.addEmployee(employee);
        } else {
            adminService.updateEmployee(employee);
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
            model.addAttribute("skillList", skillService.getAllSkills());
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
    public String searchEmployee(Model model, @RequestParam("skill") String skill) {
        if(adminService.searchEmployees(skill) != null) {
            model.addAttribute("employees", adminService.searchEmployees(skill));
            return "admin/searchEmployee";
        } else {
            String error = "error";
            model.addAttribute("error", error);
            return "admin/searchEmployee";
        }
    }
    
    @RequestMapping(path = "/employeeProjects", method = RequestMethod.GET)
    public String adminAddEmployeeProject(Model model) {
        List<Employee> employees = adminService.getAllEmployees();
        List<Project> list = projectService.getAllProjects();
        model.addAttribute("employees", employees);
        model.addAttribute("skillList", list);
        return "admin/addEmployeeProject";
    }
    
    @RequestMapping(path = "/employeeProjects", method = RequestMethod.POST)
    public String projectEmployee(Model model, @RequestParam("employees") int[] employeeCode,
    		@RequestParam("project") int projectId) {
        if(adminService.addEmployeeProject(employeeCode, projectId) != null) {
            return "admin/dashboard";
        } else {
            String error = "error";
            model.addAttribute("error", error);
            return "admin/searchEmployee";
        }
    }
    
    @RequestMapping(value = "/searchEmployeesByProject", method = RequestMethod.GET)
    public String searchEmployeeByProject() {
        return "admin/searchEmployeeByProject";
    }

    @RequestMapping(path = "/searchEmployeesByProject", method = RequestMethod.POST)
    public String searchEmployeeProject(Model model, @RequestParam("project") String projectName) {
        if(adminService.searchEmployeesByProject(projectName) != null) {
            model.addAttribute("employees", adminService.searchEmployeesByProject(projectName));
            return "admin/searchEmployeeByProject";
        } else {
            String error = "error";
            model.addAttribute("error", error);
            return "admin/dashboard";
        }
    }
}