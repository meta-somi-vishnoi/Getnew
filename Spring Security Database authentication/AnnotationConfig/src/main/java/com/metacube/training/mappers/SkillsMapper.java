package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.models.Skills;

public class SkillsMapper implements RowMapper<Skills> {
    public Skills mapRow(ResultSet resultSet, int i) throws SQLException {
        Skills skill = new Skills();
        skill.setSkillId(resultSet.getInt("skill_Id"));
        skill.setSkillName(resultSet.getString("skill_Name"));
        return skill;
    }
}

