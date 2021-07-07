package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;
import com.metacube.training.models.EmployeeProject;
import com.metacube.training.models.EmployeeSkillMap;
import com.metacube.training.repository.EmployeeProjectRepository;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.EmployeeSkillRepository;

@Service
public class AdminService {
	@Autowired
	private EmployeeRepository<Employee> employeeRepository;
	
	@Autowired
	private EmployeeProjectRepository<EmployeeProject> employeeProjectRepository;
	
	@Autowired
	private EmployeeSkillRepository<EmployeeSkillMap> employeeSkillRepository;

    public Status login(String email, String password) {
        Employee employee = employeeRepository.getEmployeeByUsername(email, password);
        if (employee != null) {
            System.out.print("exist");
            return Status.EXIST;
        }
        return Status.NOT_EXIST;
    }

    public Employee getEmployeeByUsername(String email, String password) {
        return employeeRepository.getEmployeeByUsername(email, password);
    }

    public Status addEmployee(Employee employee) {
        employeeRepository.save(employee);
        int[] skills = employee.getSkills();
        Employee employeeNew = employeeRepository.getEmployeeByEmail(employee.getEmailId());
        for (int itr = 0; itr < skills.length; itr++) {
            EmployeeSkillMap employeeSkill = new EmployeeSkillMap();
            employeeSkill.setEmployeeCode(employeeNew.getCode());
            employeeSkill.setSkillId(skills[itr]);
            employeeSkillRepository.save(employeeSkill);
        }
        return Status.INSERTED;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByCode(int code) {
        return employeeRepository.getEmployeeByCode(code);
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.getEmployeeByEmail(email);
    }

    public List<Employee> searchEmployees(String skill) {
        return employeeRepository.searchEmployees(skill);
    }

    public Status updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.getEmployeeByCode(employee.getCode());
        if (employee != null) {
            employeeRepository.save(employee);
            int[] skills = employee.getSkills();
            for (int itr = 0; itr < skills.length; itr++) {
                if(employeeSkillRepository.getEmployeeSkill(employee.getCode(),skills[itr])==null) {
                    EmployeeSkillMap employeeSkill = new EmployeeSkillMap();
                    employeeSkill.setEmployeeCode(employee.getCode());
                    employeeSkill.setSkillId(skills[itr]);
                    employeeSkillRepository.save(employeeSkill);
                }
            }
            return Status.UPDATED;
        } else {
        	return Status.NOT_EXIST;
        }
    }

    public Status deleteEmployeeByCode(int code) {
        Employee employee = employeeRepository.getEmployeeByCode(code);
        if (employee != null) {
            employeeRepository.deleteEmployee("true", employee.getCode());
            return Status.DELETED;
        }
        return Status.NOT_EXIST;
    }
    
    public Status addEmployeeProject(int[] employeeCode, int projectId) {
    	 for (int itr = 0; itr < employeeCode.length; itr++) {
             EmployeeProject employeeProject = new EmployeeProject();
             employeeProject.setEmployeeCode(employeeCode[itr]);
             employeeProject.setProjectId(projectId);
             employeeProjectRepository.save(employeeProject);
         }
         return Status.INSERTED;
    }
    
    public List<Employee> searchEmployeesByProject(String projectName) {
        return employeeRepository.searchEmployeesByProject(projectName);
    }
}
