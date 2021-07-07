package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.models.EmployeeProject;

public interface EmployeeProjectRepository<P> extends JpaRepository<EmployeeProject, Integer> {

	public EmployeeProject getEmployeeProject(int employeeCode, int projectId);

}
