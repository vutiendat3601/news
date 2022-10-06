package com.dv.service;

import java.util.List;

import com.dv.model.NewsModel;
import com.dv.paging.Pageable;

public interface NewsService {
    List<NewsModel> findAll();

    List<NewsModel> findAll(Pageable page);

    NewsModel findOne(Long id);

    NewsModel save(NewsModel news);

    List<NewsModel> findByCategoryId(Long categoryId);

    Long getTotalItem();
}
