package com.dv.service.impl;

import java.util.List;

import com.dv.dao.CategoryDAO;
import com.dv.dao.NewsDAO;
import com.dv.dao.impl.CategoryDAOImpl;
import com.dv.dao.impl.NewsDAOImpl;
import com.dv.model.CategoryModel;
import com.dv.model.NewsModel;
import com.dv.service.NewsService;

public class NewsServiceImpl implements NewsService {

    private NewsDAO newsDAO = new NewsDAOImpl();

    private CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public List<NewsModel> findAll() {
        List<NewsModel> newses = newsDAO.findAll();
        return newses;
    }

    @Override
    public NewsModel findOne(Long id) {
        NewsModel news = newsDAO.findOne(id);
        return news;
    }

    @Override
    public NewsModel save(NewsModel news) {
        // <---
        CategoryModel category = categoryDAO.findOneByCode(news.getCategoryCode());
        news.setCategoryId(category.getId());
        Long id = newsDAO.save(news);

        // --->
        news = newsDAO.findOne(id);
        return news;
    }

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        List<NewsModel> newses = newsDAO.findByCategoryId(categoryId);
        return newses;
    }

}
