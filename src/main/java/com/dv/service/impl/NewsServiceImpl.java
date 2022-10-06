package com.dv.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dv.dao.CategoryDAO;
import com.dv.dao.NewsDAO;
import com.dv.model.CategoryModel;
import com.dv.model.NewsModel;
import com.dv.paging.Pageable;
import com.dv.service.NewsService;

public class NewsServiceImpl implements NewsService {

    @Inject
    private NewsDAO newsDAO;

    @Inject
    private CategoryDAO categoryDAO;

    @Override
    public List<NewsModel> findAll() {
        List<NewsModel> newses = newsDAO.findAll();
        return newses;
    }

    @Override
    public List<NewsModel> findAll(Pageable page) {
        List<NewsModel> newses = newsDAO.findAll(page);
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

    @Override
    public Long getTotalItem() {
        Long totalItem = newsDAO.getTotalItem();
        return totalItem;
    }

}
