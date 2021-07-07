package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.models.JobTitle;
import com.metacube.training.models.Skills;
@Service
public class JobDao {
	public Status addJob(JobTitle job) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionToDatabase.getConnection();
			String query = Queries.ADD_JOB;
			statement = connection.prepareStatement(query);
			statement.setString(1, job.getJobTitle());
			int result = statement.executeUpdate();
			if (result > 0) {
				return Status.INSERTED;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Status.NOT_INSERTED;
	}

	public List<JobTitle> getAllJobs() {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		List<JobTitle> listOfJobs = new ArrayList<JobTitle>();
		try {
			connection = ConnectionToDatabase.getConnection();
			String query = Queries.GET_ALL_JOBS;
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			JobTitle job;
			while (resultSet.next()) {
				job = new JobTitle();
				job.setJobCode(resultSet.getInt("job_code"));
				job.setJobTitle(resultSet.getString("job_title"));
				listOfJobs.add(job);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listOfJobs;
	}

	public JobTitle getJobByCode(int code) {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		JobTitle job = null;
		try {
			connection = ConnectionToDatabase.getConnection();
			String query = Queries.GET_JOB_BY_CODE;
			statement = connection.prepareStatement(query);
			statement.setInt(1, code);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				job = new JobTitle();
				job.setJobCode(resultSet.getInt("job_code"));
				job.setJobTitle(resultSet.getString("job_title"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return job;
	}
	
	public Status updateJob(JobTitle job) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionToDatabase.getConnection();
			String query = Queries.UPDATE_JOB;
			statement = connection.prepareStatement(query);
			statement.setString(1, job.getJobTitle());
			statement.setInt(2, job.getJobCode());
			int result = statement.executeUpdate();
			if (result > 0) {
				return Status.UPDATED;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Status.NOT_UPDATED;
	}
	
	public Status deleteJob(int code) {
        Connection connection = null ;
        PreparedStatement statement = null;
        try {
            connection = ConnectionToDatabase.getConnection();
            String query = Queries.DELETE_JOB;
            statement = connection.prepareStatement(query);
            statement.setInt(1, code);
            int result = statement.executeUpdate();
            if (result > 0) {
                return Status.DELETED;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Status.NOT_DELETED;
    }
}
