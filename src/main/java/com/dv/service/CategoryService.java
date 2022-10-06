package com.dv.service;

import java.util.List;

import com.dv.model.CategoryModel;

public interface CategoryService {
    List<CategoryModel> findAll();

    CategoryModel findOne(Long id);

    CategoryModel save(CategoryModel role);
}
