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
import com.metacube.training.mappers.JobMapper;
import com.metacube.training.mappers.SkillsMapper;
import com.metacube.training.models.Project;
import com.metacube.training.models.Skills;

@Repository
public class SkillsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SkillsDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Status addSkill(Skills skill) {
        boolean result = jdbcTemplate.update(Queries.ADD_SKILL, skill.getSkillName()) > 0;
        if (result == true) {
            return Status.INSERTED;
        } else {
            return Status.NOT_INSERTED;
        }
    }

    public List<Skills> getAllSkills() {
        return jdbcTemplate.query(Queries.GET_ALL_SKILLS, new SkillsMapper());
    }

    public Skills getSkillById(int id) {
        return jdbcTemplate.queryForObject(Queries.GET_SKILL_BY_ID, new Object[] { id }, new SkillsMapper());
    }

    public Status updateSkill(Skills skill) {
        boolean result = jdbcTemplate.update(Queries.UPDATE_JOB, skill.getSkillName(), skill.getSkillId()) > 0;
        if (result == true) {
            return Status.UPDATED;
        } else {
            return Status.NOT_UPDATED;
        }
    }

    public Status deleteSkill(Skills skill) {
        boolean result = jdbcTemplate.update(Queries.DELETE_JOB, skill.getSkillId()) > 0;
        if (result == true) {
            return Status.DELETED;
        } else {
            return Status.NOT_DELETED;
        }
    }
}
