package com.dv.dao.impl;

import java.util.List;

import com.dv.dao.CategoryDAO;
import com.dv.mapper.CategoryMapper;
import com.dv.mapper.RowMapper;
import com.dv.model.CategoryModel;

public class CategoryDAOImpl extends AbstractDAO<CategoryModel> implements CategoryDAO {
    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        RowMapper<CategoryModel> mapper = new CategoryMapper();
        List<CategoryModel> categories = query(sql, mapper);
        return categories;
    }

    @Override
    public CategoryModel findOne(Long id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        RowMapper<CategoryModel> mapper = new CategoryMapper();
        List<CategoryModel> categories = query(sql, mapper, id);
        CategoryModel category = categories.isEmpty() ? null : categories.get(0);
        return category;
    }

    @Override
    public Long save(CategoryModel category) {
        Long id = null;
        String sql = "INSERT INTO category(name, code) VALUES(?, ?)";
        id = insert(sql, category.getName(), category.getCode());
        return id;
    }

    @Override
    public CategoryModel findOneByCode(String code) {
        String sql = "SELECT * FROM category WHERE code = ?";
        RowMapper<CategoryModel> mapper = new CategoryMapper();
        List<CategoryModel> categories = query(sql, mapper, code);
        CategoryModel category = categories.isEmpty() ? null : categories.get(0);
        return category;
    }
}
