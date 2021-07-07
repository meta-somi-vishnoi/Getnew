package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.models.Employee;

@Repository
public class AdminDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Status addEmployee(Employee employee) {
        boolean result = jdbcTemplate.update(Queries.ADD_EMPLOYEE, employee.getFirstName(), employee.getMiddleName(),
            employee.getLastName(), employee.getDob(), employee.getGender(), employee.getEmailId(), employee.getContact(),
            employee.getSkypeId(), employee.getProfilePicture(), employee.getSkills()) > 0;
        if (result == true) {
            return Status.INSERTED;
        } else {
            return Status.NOT_INSERTED;
        }
    }

    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query(Queries.GET_ALL_EMPLOYEES, new EmployeeMapper());
    }

    public Employee getEmployeeByUsername(String email, String password) {
        return jdbcTemplate.queryForObject(Queries.GET_EMPLOYEE_BY_USERNAME, new Object[] { email, password }, new EmployeeMapper());
    }
    
    public Employee getEmployeeByCode(int code) {
        return jdbcTemplate.queryForObject(Queries.GET_EMPLOYEE_BY_CODE, new Object[] { code }, new EmployeeMapper());
    }

    public Employee getEmployeeByEmail(String email) {
        return jdbcTemplate.queryForObject(Queries.GET_EMPLOYEE_BY_EMAIL, new Object[] { email }, new EmployeeMapper());
    }

    public List<Employee> searchEmployees(String firstName, String lastName) {
        return jdbcTemplate.query(Queries.SEARCH_EMPLOYEES, new Object[]{firstName, lastName},
            new EmployeeMapper());
    }

    public Status updateEmployee(Employee employee) {
        boolean result = jdbcTemplate.update(Queries.UPDATE_EMPLOYEE, employee.getFirstName(), employee.getMiddleName(),
            employee.getLastName(), employee.getDob(), employee.getGender(), employee.getEmailId(), employee.getContact(),
            employee.getSkypeId(), employee.getProfilePicture(), employee.getSkills(), employee.getCode()) > 0;
        if (result == true) {
            return Status.UPDATED;
        } else {
            return Status.NOT_UPDATED;
        }
    }

    public Status deleteEmployee(Employee employee) {
        boolean result = jdbcTemplate.update(Queries.DELETE_EMPLOYEE, employee.getCode()) > 0;
        if (result == true) {
            return Status.DELETED;
        } else {
            return Status.NOT_DELETED;
        }
    }
    
    public Status updatePassword(String email, String password) {
    	boolean result = jdbcTemplate.update(Queries.UPDATE_PASSWORD, password, email) > 0;
    	if(result == true) {
    		return Status.UPDATED;
    	}else {
            return Status.NOT_UPDATED;
        }
    }
}
