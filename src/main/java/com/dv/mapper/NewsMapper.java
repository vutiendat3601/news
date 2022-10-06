package com.dv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dv.model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel> {

    @Override
    public NewsModel map(ResultSet resultSet) {
        NewsModel news = null;
        if (resultSet != null) {
            news = new NewsModel();
            try {
                news.setId(resultSet.getLong("id"));
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));
                news.setThumbnail(resultSet.getString("thumbnail"));
                news.setShortDescription(resultSet.getString("short_description"));
                news.setCategoryId(resultSet.getLong("category_id"));
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return news;
    }

}
