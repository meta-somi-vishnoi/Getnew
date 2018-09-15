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
import com.metacube.training.models.Project;

@Repository
@Transactional
public class ProjectDao {

    @Autowired
	private SessionFactory sessionFactory;

	public Status addProject(Project project) {
		if (sessionFactory.getCurrentSession().save(project) != null) {
			return Status.INSERTED;
		} else {
			return Status.NOT_INSERTED;
		}
	}

	public List<Project> getAllProjects() {
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery("from Project");
		return query.getResultList();
	}

	public Project getProjectById(int projectId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Project.class);
		criteria.add(Restrictions.eq("projectId", projectId));
		return (Project) criteria.uniqueResult();
	}

	public Status updateProject(Project project) {
		sessionFactory.getCurrentSession().update(project);
		return Status.UPDATED;
	}
	
	public Status deleteProject(Project project) {
	    sessionFactory.getCurrentSession().delete(project);
	    return Status.DELETED;
    }
}