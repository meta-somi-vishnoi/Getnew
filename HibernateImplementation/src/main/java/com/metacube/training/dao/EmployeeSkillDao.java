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
import com.metacube.training.models.EmployeeSkillMap;
import com.metacube.training.models.Skills;

@Repository
@Transactional
public class EmployeeSkillDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    public Status addEmployeeSkill(EmployeeSkillMap employeeSkill) {
        if (sessionFactory.getCurrentSession().save(employeeSkill) != null) {
            return Status.INSERTED;
        } else {
            return Status.NOT_INSERTED;
        }
    }
    
    public List<EmployeeSkillMap> getAllEmployeeSkill() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeSkillMap.class);
        return criteria.list();
    }
    
    public EmployeeSkillMap getEmployeeSkill(int employeeCode, int skillId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeSkillMap.class);
        criteria.add(Restrictions.eq("employeeCode", employeeCode));
        criteria.add(Restrictions.eq("skillId", skillId));
        return (EmployeeSkillMap) criteria.uniqueResult();
    }
}
