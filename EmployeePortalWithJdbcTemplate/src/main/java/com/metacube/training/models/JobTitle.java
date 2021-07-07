 package com.metacube.training.models;

public class JobTitle {
    private int jobCode;
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
