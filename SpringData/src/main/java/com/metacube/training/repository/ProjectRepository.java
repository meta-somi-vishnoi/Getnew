package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.models.Project;

public interface ProjectRepository<P> extends JpaRepository<Project, Long> {
	
	public Project getProjectById(int projectId);
	
	@Modifying
	@Query("DELETE from Project WHERE projectId = ?1")
	public int deleteProject(int projectId);
}
