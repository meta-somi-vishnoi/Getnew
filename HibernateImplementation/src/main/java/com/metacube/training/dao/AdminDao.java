package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;

@Repository
@Transactional
public class AdminDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private final String UPDATE_PASSWORD = "UPDATE Employee SET password= :password WHERE email = :email";
  
    public Status addEmployee(Employee employee) {
        if (sessionFactory.getCurrentSession().save(employee) != null) {
            return Status.INSERTED;
        } else {
            return Status.NOT_INSERTED;
        }
    }

    public List<Employee> getAllEmployees() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("enabled", "true"));
        return criteria.list();
    }

    public Employee getEmployeeByUsername(String email, String password) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("emailId", email));
        criteria.add(Restrictions.eq("password", password));
        return (Employee) criteria.uniqueResult();
    }
    
    public Employee getEmployeeByCode(int code) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("code", code));
        criteria.add(Restrictions.eq("enabled", "true"));
        return (Employee) criteria.uniqueResult();
    }

    public Employee getEmployeeByEmail(String email) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("emailId", email));
        criteria.add(Restrictions.eq("enabled", "true"));
        return (Employee) criteria.uniqueResult();
    }

    public List<Employee> searchEmployees(String skill) {
        TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery
        ("Select e from Employee e, EmployeeSkillMap es , Skills sm where e.code = es.employeeCode AND sm.skillId = es.skillId "
            + "AND sm.skillName = :skill");
        query.setParameter("skill" , skill);
        return query.getResultList();
    }

    public Status updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return Status.UPDATED;
    }

    public Status deleteEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
        return Status.DELETED;
    }
    
    public Status updatePassword(String email, String password) {
        TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery(UPDATE_PASSWORD);
        query.setParameter("password", password);
        query.setParameter("email", email);
    	if(query.executeUpdate() > 0) {
    		return Status.UPDATED;
    	}else {
            return Status.NOT_UPDATED;
        }
    }
}