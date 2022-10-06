package com.dv.dao;

import java.util.List;

import com.dv.model.CategoryModel;

public interface CategoryDAO {
    List<CategoryModel> findAll();

    CategoryModel findOne(Long id);

    CategoryModel findOneByCode(String code);

    Long save(CategoryModel category);
}
