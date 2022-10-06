package com.dv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dv.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

    @Override
    public CategoryModel map(ResultSet resultSet) {
        CategoryModel category = null;
        if (resultSet != null) {
            category = new CategoryModel();
            try {
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
                category.setCode(resultSet.getString("code"));
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return category;
    }

}
