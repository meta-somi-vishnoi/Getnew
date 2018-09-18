package com.metacube.training.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_title")
public class JobTitle {
	
	@Id
	@Column(name = "job_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobCode;
	
	@Column(name = "job_title")
    private String jobTitle;
    
    public int getJobCode() {
        return jobCode;
    } 
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    public void setJobCode(int jobCode) {
        this.jobCode = jobCode;
    }
}
