package com.metacube.training.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.metacube.training.Status.Status;
import com.metacube.training.dao.AdminDao;
import com.metacube.training.models.Project;
import com.metacube.training.models.Employee;


public class AdminService {
    private static AdminService adminService = new AdminService();
    
    private AdminDao adminDao;
 
    public static AdminService getInstance() {
        return adminService;
    }
    
    public Status login(String email, String password) {
        adminDao = AdminDao.getInstance();
        List<Employee> listOfEmployee = new ArrayList<Employee>();
        listOfEmployee = adminDao.getAllEmployees();
        System.out.println(email + " " + password);
        for (Employee existingEmployee : listOfEmployee) {
             System.out.println(existingEmployee.getEmailId());
            if (email.equals(existingEmployee.getEmailId()) && password.equals(existingEmployee.getPassword())) {
                System.out.print("exist");
                return Status.EXIST;
            }
        }
        System.out.print("not");
        return Status.NOT_EXIST;
    }
    
    public Status addEmployee(Employee employee) {
        AdminDao adminDao = AdminDao.getInstance();
        Status status = adminDao.addEmployee(employee);
        return status;
    }
    
    public List<Employee> getAllEmployees() {
        adminDao = AdminDao.getInstance();
        return adminDao.getAllEmployees();
    }
    
    public Employee getEmployeeByCode(int code) {
        adminDao = AdminDao.getInstance();
        return adminDao.getEmployeeByCode(code);
    }
    
    public Employee getEmployeeByEmail(String email) {
        adminDao = AdminDao.getInstance();
        return adminDao.getEmployeeByEmail(email);
    }  
    
    public List<Employee> searchEmployees(String firstName, String lastName) {
        adminDao = AdminDao.getInstance();
        return adminDao.searchEmployees(firstName, lastName);
    }
    
    public Status updateEmployee(Employee employee) {
        adminDao = AdminDao.getInstance();
        List<Employee> listOfEmployee = new ArrayList<Employee>();
        listOfEmployee = adminDao.getAllEmployees();
        for (Employee existingEmployee : listOfEmployee) {
            if (employee.getCode()==existingEmployee.getCode()) {
                Status status = adminDao.updateEmployee(employee);
                return status;
            }
        } 
        return Status.NOT_EXIST;
    }
    
    public Status deleteEmployeeByCode(int code) {
        adminDao = AdminDao.getInstance();
        List<Employee> listOfEmployee = new ArrayList<Employee>();
        listOfEmployee = adminDao.getAllEmployees();
        for (Employee existingEmployee : listOfEmployee) {
            if (code==existingEmployee.getCode()) {
                Status status = adminDao.deleteEmployee(code);
                return status;
            }
        } 
        return Status.NOT_EXIST;
    }
}
