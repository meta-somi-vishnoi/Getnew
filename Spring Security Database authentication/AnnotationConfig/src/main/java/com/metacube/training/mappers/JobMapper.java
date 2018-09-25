package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.models.JobTitle;
import com.metacube.training.models.Project;

public class JobMapper implements RowMapper<JobTitle> {
    public JobTitle mapRow(ResultSet resultSet, int i) throws SQLException {
        JobTitle job = new JobTitle();
        job.setJobCode(resultSet.getInt("job_Code"));
        job.setJobTitle(resultSet.getString("job_Title"));
        return job;
    }
}
