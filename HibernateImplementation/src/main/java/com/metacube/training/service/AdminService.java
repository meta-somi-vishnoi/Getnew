package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.AdminDao;
import com.metacube.training.dao.EmployeeSkillDao;
import com.metacube.training.models.Employee;
import com.metacube.training.models.EmployeeSkillMap;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private EmployeeSkillDao employeeSkillDao;

    public Status login(String email, String password) {
        Employee employee = getEmployeeByUsername(email, password);
        if (employee != null) {
            System.out.print("exist");
            return Status.EXIST;
        }
        return Status.NOT_EXIST;
    }

    public Employee getEmployeeByUsername(String email, String password) {
        return adminDao.getEmployeeByUsername(email, password);
    }

    public Status addEmployee(Employee employee) {
        Status status = adminDao.addEmployee(employee);
        int[] skills = employee.getSkills();
        employee = adminDao.getEmployeeByEmail(employee.getEmailId());
        for (int itr = 0; itr < skills.length; itr++) {
            EmployeeSkillMap employeeSkill = new EmployeeSkillMap();
            employeeSkill.setEmployeeCode(employee.getCode());
            employeeSkill.setSkillId(skills[itr]);
            employeeSkillDao.addEmployeeSkill(employeeSkill);
        }
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

    public List<Employee> searchEmployees(String skill) {
        return adminDao.searchEmployees(skill);
    }

    public Status updateEmployee(Employee employee) {
        Employee existingEmployee = adminDao.getEmployeeByCode(employee.getCode());
        if (employee != null) {
            Status status = adminDao.updateEmployee(employee);
            int[] skills = employee.getSkills();
            for (int itr = 0; itr < skills.length; itr++) {
                if(employeeSkillDao.getEmployeeSkill(employee.getCode(),skills[itr])==null) {
                    EmployeeSkillMap employeeSkill = new EmployeeSkillMap();
                    employeeSkill.setEmployeeCode(employee.getCode());
                    employeeSkill.setSkillId(skills[itr]);
                    employeeSkillDao.addEmployeeSkill(employeeSkill);
                }
            }
            return status;
        }
        return Status.NOT_EXIST;
    }

    public Status deleteEmployeeByCode(int code) {
        Employee employee = adminDao.getEmployeeByCode(code);
        if (employee != null) {
            Status status = adminDao.deleteEmployee(employee);
            return status;
        }
        return Status.NOT_EXIST;
    }

    public Status updatePassword(String email, String password) {
        Employee employee = adminDao.getEmployeeByEmail(email);
        if (employee != null) {
            Status status = adminDao.updatePassword(email, password);
            return status;
        }
        return Status.NOT_EXIST;
    }
}
