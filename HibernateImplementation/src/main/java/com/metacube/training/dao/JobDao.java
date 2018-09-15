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
import com.metacube.training.models.JobTitle;

@Repository
@Transactional
public class JobDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    public Status addJob(JobTitle job) {
        if (sessionFactory.getCurrentSession().save(job) != null) {
            return Status.INSERTED;
        } else {
            return Status.NOT_INSERTED;
        }
    }

    public List<JobTitle> getAllJobs() {
        TypedQuery<JobTitle> query = sessionFactory.getCurrentSession().createQuery("from JobTitle");
        return query.getResultList();
    }

    public JobTitle getJobByCode(int code) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobTitle.class);
        criteria.add(Restrictions.eq("jobCode", code));
        return (JobTitle) criteria.uniqueResult();
    }

    public Status updateJob(JobTitle job) {
        sessionFactory.getCurrentSession().update(job);
        return Status.UPDATED;
    }

    public Status deleteJob(JobTitle job) {
        sessionFactory.getCurrentSession().delete(job);
        return Status.DELETED;
    }
}
