package com.metacube.training.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.dao.AdminDao;
import com.metacube.training.dao.ProjectDao;
import com.metacube.training.models.Employee;
import com.metacube.training.models.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;

	public Status addProject(Project project) {
        Status status = projectDao.addProject(project);
        return status;
    }
	
	public Project getProjectById(int id) {
		return projectDao.getProjectById(id);
	}

	public List<Project> getAllProjects() {
		return projectDao.getAllProjects();
	}

	public Status deleteProject(int id) {
		Project project = projectDao.getProjectById(id);
		if(project==null) {
			return Status.NOT_EXIST;
		} else {
			Status status = projectDao.deleteProject(id);
			return status;
		}
	}

	public Status updateProject(Project project) {
		List<Project> listOfProject = new ArrayList<Project>();
        listOfProject = projectDao.getAllProjects();
        for (Project existingProject : listOfProject) {
            if (project.getProjectId()== existingProject.getProjectId()) {
                Status status = projectDao.updateProject(project);
                return status;
            }
        } 
        return Status.NOT_EXIST;
	}
}
