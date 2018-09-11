package com.metacube.training.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.AdminDao;
import com.metacube.training.models.Project;
import com.metacube.training.models.Employee;

@Service
public class AdminService {
    private static AdminService adminService = new AdminService();
    
    @Autowired
    private AdminDao adminDao;
    
    public Status login(String email, String password) {
        List<Employee> listOfEmployee = new ArrayList<Employee>();
        listOfEmployee = adminDao.getAllEmployees();
        for (Employee existingEmployee : listOfEmployee) {
             System.out.println(existingEmployee.getEmailId() + " " + existingEmployee.getPassword());
            if (email.equals(existingEmployee.getEmailId()) && password.equals(existingEmployee.getPassword())) {
                System.out.print("exist");
                return Status.EXIST;
            }
        }
        return Status.NOT_EXIST;
    }
    
    public Status addEmployee(Employee employee) {
        Status status = adminDao.addEmployee(employee);
        return status;
    }
    
    public List<Employee> getAllEmployees() {
        return adminDao.getAllEmployees();
    }
    
    public Employee getEmployeeByCode(int code) {
        return adminDao.getEmployeeByCode(code);
    }
    
    public Employee getEmployeeByEmail(String email) {
        return adminDao.getEmployeeByEmail(email);
    }  
    
    public List<Employee> searchEmployees(String firstName, String lastName) {
        return adminDao.searchEmployees(firstName, lastName);
    }
    
    public Status updateEmployee(Employee employee) {
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
        List<Employee> listOfEmployee = new ArrayList<Employee>();
        listOfEmployee = adminDao.getAllEmployees();
        for (Employee existingEmployee : listOfEmployee) {
            if (code==existingEmployee.getCode()) {
                Status status = adminDao.deleteEmployee(existingEmployee);
                return status;
            }
        } 
        return Status.NOT_EXIST;
    }
}
