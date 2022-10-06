package com.dv.dao;

import java.util.List;

import com.dv.model.NewsModel;
import com.dv.paging.Pageable;

public interface NewsDAO {
    List<NewsModel> findAll();

    List<NewsModel> findAll(Pageable page);

    List<NewsModel> findByCategoryId(Long id);

    NewsModel findOne(Long id);

    Long save(NewsModel role);

    Long getTotalItem();

}
