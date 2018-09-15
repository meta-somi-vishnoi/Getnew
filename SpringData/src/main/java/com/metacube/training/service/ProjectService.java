package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.Status.Status;
import com.metacube.training.models.JobTitle;
import com.metacube.training.models.Project;
import com.metacube.training.repository.JobRepository;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository<Project> projectRepository;

    public Status addProject(Project project) {
        projectRepository.save(project);
        return Status.INSERTED;
    }

    public Project getProjectById(int id) {
        return projectRepository.getProjectById(id);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Status deleteProject(int id) {
        Project project = projectRepository.getProjectById(id);
        if (project == null) {
            return Status.NOT_EXIST;
        } else {
            projectRepository.deleteProject(project.getProjectId());
            return Status.DELETED;
        }
    }

    public Status updateProject(Project project) {
        Project projectPresent = projectRepository.getProjectById(project.getProjectId());
        if (projectPresent != null) {
            projectRepository.save(project);
            return Status.UPDATED;
        }
        return Status.NOT_EXIST;
    }
}