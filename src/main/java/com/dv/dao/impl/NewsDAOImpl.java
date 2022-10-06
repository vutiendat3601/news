package com.dv.dao.impl;

import java.util.List;

import com.dv.dao.NewsDAO;
import com.dv.mapper.NewsMapper;
import com.dv.mapper.RowMapper;
import com.dv.model.NewsModel;

public class NewsDAOImpl extends AbstractDAO<NewsModel> implements NewsDAO {

    @Override
    public List<NewsModel> findAll() {
        String sql = "SELECT * FROM news ";
        RowMapper<NewsModel> mapper = new NewsMapper();
        List<NewsModel> roles = query(sql, mapper);
        return roles;
    }

    @Override
    public List<NewsModel> findAll(Integer limit, Integer offset) {
        List<NewsModel> newses = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM news");
        RowMapper<NewsModel> mapper = new NewsMapper();
        if (limit != null && offset != null) {
            sql.append(" LIMIT ? OFFSET ? ");
            newses = query(sql.toString(), mapper, limit, offset);
        } else {
            newses = query(sql.toString(), mapper);
        }
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
