package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.models.Employee;
import com.metacube.training.models.Project;

@Repository
public class ProjectDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Status addProject(Project project) {
        boolean result = jdbcTemplate.update(Queries.ADD_PROJECT, project.getName(), project.getDescription(),
            project.getStartDate(), project.getEndDate(), project.getProjectLogo()) > 0;
        if (result == true) {
            return Status.INSERTED;
        } else {
            return Status.NOT_INSERTED;
        }
    }

    public List<Project> getAllProjects() {
        try {
            return jdbcTemplate.query(Queries.GET_ALL_PROJECTS, new ProjectMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Project getProjectById(int id) {
        try {
            return jdbcTemplate.queryForObject(Queries.GET_PROJECT_BY_ID, new Object[] { id }, new ProjectMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Status updateProject(Project project) {
        boolean result = jdbcTemplate.update(Queries.UPDATE_PROJECT, project.getName(), project.getDescription(),
            project.getStartDate(), project.getEndDate(), project.getProjectLogo(), project.getProjectId()) > 0;
        if (result == true) {
            return Status.UPDATED;
        } else {
            return Status.NOT_UPDATED;
        }
    }

    public Status deleteProject(Project project) {
        boolean result = jdbcTemplate.update(Queries.DELETE_EMPLOYEE, project.getProjectId()) > 0;
        if (result == true) {
            return Status.DELETED;
        } else {
            return Status.NOT_DELETED;
        }
    }
}
