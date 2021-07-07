package com.metacube.training.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.AdminDao;
import com.metacube.training.models.Employee;

@Service
public class ValidateService {

    @Autowired
    private AdminDao adminDao;

    public Status validateAddEmployee(Employee employee) {
        if (adminDao.getEmployeeByEmail(employee.getEmailId()) != null) {
            return Status.EXIST;
        }
        return Status.NOT_EXIST;
    }

    public Status validateUpdateEmployee(Employee employee) {
        Employee existingEmployee = adminDao.getEmployeeByCode(employee.getCode());
        if (existingEmployee != null) {
            return Status.EXIST;
        }
        return Status.NOT_EXIST;
    }

    public Status validateSession(HttpSession session) {
        if (session != null) {
            return Status.EXIST;
        }
        return Status.NOT_EXIST;
    }
}