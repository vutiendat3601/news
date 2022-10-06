package com.dv.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dv.dao.GenericDAO;
import com.dv.mapper.RowMapper;
import com.dv.util.DBUtil;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

    @Override
    public List<T> query(String sql, RowMapper<T> mapper, Object... params) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                setParameter(statement, params);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    T t = mapper.map(resultSet);
                    results.add(t);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return results;
    }

    @Override
    public Long insert(String sql, Object... params) {
        Long id = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                setParameter(statement, params);
                statement.executeUpdate();
                resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return id;
    }

    @Override
    public void update(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                setParameter(statement, params);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public Integer count(String sql, Object... params) {
        Integer count = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                setParameter(statement, params);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    // Helper
    private void setParameter(PreparedStatement statement, Object... params) {
        try {

            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof Long) {
                    statement.setLong(i + 1, (Long) params[i]);
                } else if (params[i] instanceof Integer) {
                    statement.setInt(i + 1, (Integer) params[i]);
                } else if (params[i] instanceof String) {
                    statement.setString(i + 1, (String) params[i]);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}