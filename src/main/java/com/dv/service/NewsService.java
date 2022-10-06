package com.dv.service;

import java.util.List;

import com.dv.model.NewsModel;

public interface NewsService {
    List<NewsModel> findAll();

    List<NewsModel> findAll(Integer limit, Integer offset);

    NewsModel findOne(Long id);

    NewsModel save(NewsModel news);

    List<NewsModel> findByCategoryId(Long categoryId);

    Long getTotalItem();
}
