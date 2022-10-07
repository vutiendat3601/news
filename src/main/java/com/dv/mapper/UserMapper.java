package com.dv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dv.model.RoleModel;
import com.dv.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

    @Override
    public UserModel map(ResultSet resultSet) {
        UserModel user = null;
        if (resultSet != null) {
            user = new UserModel();
            try {
                user.setId(resultSet.getLong("id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRoleId(resultSet.getLong("role_id"));
                user.setStatus(resultSet.getInt("status"));
                
                RoleModel role =new RoleModel();
                role.setId(user.getRoleId());
                role.setCode(user.getRoleCode());
                user.setRole(role);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return user;
    }

}
