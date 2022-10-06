package com.dv.service.impl;

import java.util.List;

import com.dv.dao.CategoryDAO;
import com.dv.dao.impl.CategoryDAOImpl;
import com.dv.model.CategoryModel;
import com.dv.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public List<CategoryModel> findAll() {
        List<CategoryModel> categories = categoryDAO.findAll();
        return categories;
    }

    @Override
    public CategoryModel findOne(Long id) {
        CategoryModel category = categoryDAO.findOne(id);
        return category;
    }

    @Override
    public CategoryModel save(CategoryModel category) {
        Long id = categoryDAO.save(category);
        category = categoryDAO.findOne(id);
        return category;
    }

}
