package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.models.Project;

public class ProjectMapper implements RowMapper<Project> {

	public Project mapRow(ResultSet resultSet, int i) throws SQLException {
		Project project = new Project();
		project.setProjectId(resultSet.getInt("project_Id"));
		project.setName(resultSet.getString("name"));
		project.setDescription(resultSet.getString("description"));
		project.setStartDate(resultSet.getDate("start_date"));
		project.setEndDate(resultSet.getDate("end_date"));
		project.setProjectLogo(resultSet.getString("project_logo"));
		return project;
	}
}
