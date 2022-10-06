package com.dv.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.dv.dao.NewsDAO;
import com.dv.mapper.NewsMapper;
import com.dv.mapper.RowMapper;
import com.dv.model.NewsModel;
import com.dv.paging.Pageable;
import com.dv.sort.Sorter;

public class NewsDAOImpl extends AbstractDAO<NewsModel> implements NewsDAO {

    @Override
    public List<NewsModel> findAll() {
        String sql = "SELECT * FROM news ";
        RowMapper<NewsModel> mapper = new NewsMapper();
        List<NewsModel> roles = query(sql, mapper);
        return roles;
    }

    @Override
    public List<NewsModel> findAll(Pageable page) {
        List<NewsModel> newses = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM news ");

        Sorter sorter = page.getSorter();
        if (sorter != null && !StringUtils.isBlank(sorter.getSortType()) &&
                !StringUtils.isBlank(sorter.getSortBy())) {
            sql.append(" ORDER BY " + sorter.getSortBy() + " " + sorter.getSortType() + " ");
        }
        if (page.getLimit() != null && page.getOffset() != null) {
            sql.append(" LIMIT " + page.getLimit() + " OFFSET " + page.getOffset() + " ");
        }

        RowMapper<NewsModel> mapper = new NewsMapper();
        newses = query(sql.toString(), mapper);
        return newses;
    }

    @Override
    public NewsModel findOne(Long id) {
        String sql = "SELECT * FROM news WHERE id = ? ";
        RowMapper<NewsModel> mapper = new NewsMapper();
        List<NewsModel> newses = query(sql, mapper, id);
        NewsModel news = newses.isEmpty() ? null : newses.get(0);
        return news;
    }

    @Override
    public Long save(NewsModel news) {
        Long id = null;
        String sql = "INSERT INTO news(title, thumbnail, content, short_description, category_id) " +
                " VALUES(?, ?, ?, ?, ?) ";
        id = insert(sql, news.getTitle(), news.getThumbnail(), news.getContent(),
                news.getShortDescription(), news.getCategoryId());
        return id;
    }

    @Override
    public List<NewsModel> findByCategoryId(Long id) {
        String sql = "SELECT * FROM news WHERE category_id = ? ";
        RowMapper<NewsModel> mapper = new NewsMapper();
        List<NewsModel> newses = query(sql, mapper, id);
        return newses;
    }

    @Override
    public Long getTotalItem() {
        String sql = "SELECT COUNT(*) FROM news ";
        Long count = count(sql);
        return count;
    }

}
