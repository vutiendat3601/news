package com.dv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dv.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel> {

    @Override
    public RoleModel map(ResultSet resultSet) {
        RoleModel role = null;
        if (resultSet != null) {
            role = new RoleModel();
            try {
                role.setId(resultSet.getLong("id"));
                role.setName(resultSet.getString("name"));
                role.setCode(resultSet.getString("code"));
            } catch (SQLException e) {
            }
        }
        return role;
    }

}
