package com.metacube.training.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_Project")
public class EmployeeProject {
	@Id
    @Column(name = "employee_project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeProjectId;
    
    @Column(name = "employee_code")
    private int employeeCode;
    
    @Column(name = "project_id")
    private int projectId;

	public int getEmployeeProjectId() {
		return employeeProjectId;
	}

	public void setEmployeeProjectId(int employeeProjectId) {
		this.employeeProjectId = employeeProjectId;
	}

	public int getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}
