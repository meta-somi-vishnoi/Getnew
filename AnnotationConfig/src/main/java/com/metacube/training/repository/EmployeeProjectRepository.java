package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.models.EmployeeProject;

public interface EmployeeProjectRepository<P> extends JpaRepository<EmployeeProject, Integer> {

    @Query("SELECT e from EmployeeProject e where e.employeeCode = ?1 and e.projectId = ?2")
	public EmployeeProject getEmployeeProject(int employeeCode, int projectId);

}
