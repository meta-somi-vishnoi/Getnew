package com.facade;

import java.util.ArrayList;

import com.models.Employee;
import com.models.SearchEmployeeByName;
import com.dao.EmployeeDao;
import com.enums.Status;

public class EmployeeFacade {
    private static EmployeeFacade employeeFacade = new EmployeeFacade();

    public static EmployeeFacade getInstance() {
        return employeeFacade;
    }

    public Status addEmployee(Employee employee) {
        EmployeeDao employeeDao = EmployeeDao.getInstance();
        Status status = employeeDao.addEmployee(employee);
        if (status.equals(Status.INSERTED)) {
            return Status.INSERTED;
        } else {
            return Status.NOT_INSERTED;
        }
    }

    public ArrayList<Employee> searchEmployee(SearchEmployeeByName employee) {
        EmployeeDao employeeDao = EmployeeDao.getInstance();
        ArrayList<Employee> list = new ArrayList<Employee>();
        list = employeeDao.searchEmployee(employee);
        return list;
    }

    public ArrayList<Employee> showEmployee() {
        EmployeeDao employeeDao = EmployeeDao.getInstance();
        ArrayList<Employee> list = new ArrayList<Employee>();
        list = employeeDao.showEmployee();
        return list;
    }

    public Employee updateEmployee(int id) {
        EmployeeDao employeeDao = EmployeeDao.getInstance();
        Employee employee = employeeDao.updateEmployee(id);
        return employee;
    }

    public Status updateEmployeeDetails(Employee employee, int id) {
        EmployeeDao employeeDao = EmployeeDao.getInstance();
        Status status = employeeDao.updateEmployeeDetails(employee,id);
        if (status.equals(Status.UPDATED)) {
            return Status.UPDATED;
        } else {
            return Status.NOT_UPDATED;
        }
    }
}
