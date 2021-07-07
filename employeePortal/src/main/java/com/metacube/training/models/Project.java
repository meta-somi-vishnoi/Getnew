package com.metacube.training.models;

import java.sql.Date;

import javax.validation.constraints.NotNull;

public class Project {
    private int projectId;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    private String projectLogo;
    
    public int getProjectId() {
        return projectId;
    }
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getProjectLogo() {
        return projectLogo;
    }
    public void setProjectLogo(String projectLogo) {
        this.projectLogo = projectLogo;
    }
}
