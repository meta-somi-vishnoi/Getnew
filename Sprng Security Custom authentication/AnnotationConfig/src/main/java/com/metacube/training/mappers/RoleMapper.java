package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.metacube.training.models.UserRoles;

public class RoleMapper implements RowMapper<UserRoles>{
    public UserRoles mapRow(ResultSet resultSet, int i) throws SQLException {
        UserRoles role = new UserRoles();
        role.setRole(resultSet.getString("role"));
        return role;
    }
}
