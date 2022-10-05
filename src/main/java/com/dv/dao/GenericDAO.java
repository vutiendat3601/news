package com.dv.dao;

import java.util.List;

import com.dv.mapper.RowMapper;

public interface GenericDAO<T> {
    List<T> query(String sql, RowMapper<T> mapper, Object... params);

    Long insert(String sql, Object... params);

    void update(String sql, Object... params);

    Integer count(String sql, Object... params);
}
