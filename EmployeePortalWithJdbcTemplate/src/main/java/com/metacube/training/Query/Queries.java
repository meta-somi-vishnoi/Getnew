package com.metacube.training.Query;

public class Queries {
    public static final String ADD_EMPLOYEE = "INSERT INTO Employee(first_name, middle_name, last_name, "
        + "dob, gender, email, contact, skype_id, profile_picture, skills) "
        + "VALUES "
        + "(?,?,?,?,?,?,?,?,?,?)";
    
    public static final String GET_ALL_EMPLOYEES = "SELECT * from employee WHERE enabled = 'true'";
    
    public static final String GET_EMPLOYEE_BY_CODE = "SELECT * from employee "
        + "WHERE code = ?";
    
    public static final String GET_EMPLOYEE_BY_EMAIL = "SELECT * from employee "
        + "WHERE email = ?";
    
    public static final String GET_EMPLOYEE_BY_USERNAME = "SELECT * from employee "
        + "WHERE email = ? AND password = ?";
    
    public static final String SEARCH_EMPLOYEES = "SELECT * from employee "
        + "WHERE first_name = ? AND last_name =?";
    
    public static final String UPDATE_EMPLOYEE = "UPDATE Employee set first_name = ?, middle_name = ?, "
        + "last_name = ?, dob = ?, gender = ?, email = ?, contact = ?, skype_id = ?,"
        + "profile_picture = ? , skills = ? "
        + "WHERE code = ?";
    
    public static final String DELETE_EMPLOYEE = "UPDATE employee "
        + "SET enabled = 'false' " 
        + "WHERE code = ?";
    
    public static final String ADD_PROJECT = "INSERT INTO Project_Master(Name, Description, Start_Date, End_Date, Project_Logo)"
        + " VALUES "
     	+ "(?,?,?,?,?)";
    
    public static final String GET_ALL_PROJECTS = "SELECT * from project_master";

    public static final String GET_PROJECT_BY_ID = "SELECT * from project_master "
        + "WHERE project_id = ?";
    
    public static final String UPDATE_PROJECT = "UPDATE project_master set "
    	+ "name = ?, description = ?, start_date = ?, end_date = ?, project_logo = ? "
    	+ "WHERE project_id = ?";
    
    public static final String DELETE_PROJECT = "DELETE FROM project_master "
    	+ "WHERE project_id = ?";
    
    public static final String ADD_SKILL = "INSERT INTO Skill_Master(Skill_Name)"
    	+ " VALUES "
    	+ "(?)";
    
    public static final String GET_ALL_SKILLS = "SELECT * from skill_master";

    public static final String GET_SKILL_BY_ID = "SELECT * from skill_master "
    	+ "WHERE skill_id = ?";
    
    public static final String UPDATE_SKILL = "UPDATE skill_master set "
    	+ "skill_name = ? "
    	+ "WHERE skill_id = ?";
    
    public static final String UPDATE_PASSWORD = "UPDATE employee set "
    	+ "password = ? "
    	+ "WHERE email = ?";
    
    public static final String DELETE_SKILL = "DELETE FROM skill_master "
    	+ "WHERE skill_id = ?";
    
    public static final String ADD_JOB = "INSERT INTO job_title(job_title)"
    	+ " VALUES "
    	+ "(?)";
    
    public static final String GET_ALL_JOBS = "SELECT * from job_title";

    public static final String GET_JOB_BY_CODE = "SELECT * from job_title "
    	+ "WHERE job_code = ?";
    
    public static final String UPDATE_JOB = "UPDATE job_title set "
    	+ "job_title = ? "
    	+ "WHERE job_code = ?";
    
    public static final String DELETE_JOB = "DELETE FROM job_title "
    	+ "WHERE job_code = ?";
}
