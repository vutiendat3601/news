package com.dv.dao.impl;

import java.util.List;

import com.dv.dao.UserDAO;
import com.dv.mapper.RowMapper;
import com.dv.mapper.UserMapper;
import com.dv.model.UserModel;

public class UserDAOImpl extends AbstractDAO<UserModel> implements UserDAO {

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM user ";
        RowMapper<UserModel> mapper = new UserMapper();
        List<UserModel> roles = query(sql, mapper);
        return roles;
    }

    @Override
    public UserModel findOne(Long id) {
        String sql = "SELECT * FROM user WHERE id = ? ";
        RowMapper<UserModel> mapper = new UserMapper();
        List<UserModel> users = query(sql, mapper, id);
        UserModel user = users.isEmpty() ? null : users.get(0);
        return user;
    }

    @Override
    public Long save(UserModel user) {
        Long id = null;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO user(full_name, username, password, status, role_id) ");
        sql.append("VALUES(?, ?, ?, ?, ?) ");
        id = insert(sql.toString(),
                user.getFullName(), user.getUsername(), user.getPassword(),
                user.getStatus(), user.getRoleId());
        return id;
    }

    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM `user` u INNER JOIN `role` r ON r.id = u.role_id ");
        sql.append(" WHERE username = ? AND password = ? AND status = ? ");
        RowMapper<UserModel> mapper = new UserMapper();
        List<UserModel> users = query(sql.toString(), mapper, username, password, status);
        UserModel user = users.isEmpty() ? null : users.get(0);
        return user;
    }

}
