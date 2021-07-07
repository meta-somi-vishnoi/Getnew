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
import com.metacube.training.models.Project;
import com.metacube.training.models.Skills;
@Service
public class SkillsDao {
	public Status addSkill(Skills skill) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionToDatabase.getConnection();
			String query = Queries.ADD_SKILL;
			statement = connection.prepareStatement(query);
			statement.setString(1, skill.getSkillName());
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

	public List<Skills> getAllSkills() {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		List<Skills> listOfSkills = new ArrayList<Skills>();
		try {
			connection = ConnectionToDatabase.getConnection();
			String query = Queries.GET_ALL_SKILLS;
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			Skills skill;
			while (resultSet.next()) {
				skill = new Skills();
				skill.setSkillId(resultSet.getInt("skill_id"));
				skill.setSkillName(resultSet.getString("skill_name"));
				listOfSkills.add(skill);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listOfSkills;
	}

	public Skills getSkillById(int id) {
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		Skills skill = null;
		try {
			connection = ConnectionToDatabase.getConnection();
			String query = Queries.GET_SKILL_BY_ID;
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				skill = new Skills();
				skill.setSkillId(resultSet.getInt("skil_id"));
				skill.setSkillName(resultSet.getString("skill_name"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return skill;
	}
	
	public Status updateSkill(Skills skill) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionToDatabase.getConnection();
			String query = Queries.UPDATE_PROJECT;
			statement = connection.prepareStatement(query);
			statement.setString(1, skill.getSkillName());
			statement.setInt(2, skill.getSkillId());
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
	
	public Status deleteSkill(int id) {
        Connection connection = null ;
        PreparedStatement statement = null;
        try {
            connection = ConnectionToDatabase.getConnection();
            String query = Queries.DELETE_SKILL;
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
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
