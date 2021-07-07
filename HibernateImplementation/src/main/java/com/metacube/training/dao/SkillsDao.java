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
import com.metacube.training.models.Skills;

@Repository
@Transactional
public class SkillsDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    public Status addSkill(Skills skill) {
        if (sessionFactory.getCurrentSession().save(skill) != null) {
            return Status.INSERTED;
        } else {
            return Status.NOT_INSERTED;
        }
    }

    public List<Skills> getAllSkills() {
        TypedQuery<Skills> query = sessionFactory.getCurrentSession().createQuery("from Skills");
        return query.getResultList();
    }

    public Skills getSkillById(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Skills.class);
        criteria.add(Restrictions.eq("skillId", id));
        return (Skills) criteria.uniqueResult();
    }

    public Status updateSkill(Skills skill) {
        sessionFactory.getCurrentSession().update(skill);
        return Status.UPDATED;
    }

    public Status deleteSkill(Skills skill) {
        sessionFactory.getCurrentSession().delete(skill);
        return Status.DELETED;
    }
}
