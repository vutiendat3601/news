package com.dv.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T map(ResultSet resultSet);
}
