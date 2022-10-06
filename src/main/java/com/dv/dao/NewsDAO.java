package com.dv.dao;

import java.util.List;

import com.dv.model.NewsModel;

public interface NewsDAO {
    List<NewsModel> findAll();

    List<NewsModel> findByCategoryId(Long id);

    NewsModel findOne(Long id);

    Long save(NewsModel role);
}
