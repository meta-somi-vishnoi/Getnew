package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.mappers.JobMapper;
import com.metacube.training.models.JobTitle;
import com.metacube.training.models.Skills;

@Repository
public class JobDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JobDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Status addJob(JobTitle job) {
        boolean result = jdbcTemplate.update(Queries.ADD_JOB, job.getJobTitle()) > 0;
        if (result == true) {
            return Status.INSERTED;
        } else {
            return Status.NOT_INSERTED;
        }
    }

    public List<JobTitle> getAllJobs() {
        return jdbcTemplate.query(Queries.GET_ALL_JOBS, new JobMapper());
    }

    public JobTitle getJobByCode(int code) {
        return jdbcTemplate.queryForObject(Queries.GET_JOB_BY_CODE, new Object[] { code }, new JobMapper());
    }

    public Status updateJob(JobTitle job) {
        boolean result = jdbcTemplate.update(Queries.UPDATE_JOB, job.getJobTitle(), job.getJobCode()) > 0;
        if (result == true) {
            return Status.UPDATED;
        } else {
            return Status.NOT_UPDATED;
        }
    }

    public Status deleteJob(JobTitle job) {
        boolean result = jdbcTemplate.update(Queries.DELETE_JOB, job.getJobCode()) > 0;
        if (result == true) {
            return Status.DELETED;
        } else {
            return Status.NOT_DELETED;
        }
    }
}
