package com.dv.controller.admin.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dv.model.NewsModel;
import com.dv.service.NewsService;
import com.dv.util.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-news" })
public class NewsAPI extends HttpServlet {
    @Inject
    private NewsService newsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        
        // <---
        Long categoryId = Long.valueOf(req.getParameter("categoryId"));
        List<NewsModel> newses = newsService.findByCategoryId(categoryId);

        // --->
        String newsJson = HttpUtil.toJson(newses);
        PrintWriter writer = resp.getWriter();
        writer.write(newsJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        // <---
        String newsJson = HttpUtil.toJson(req);
        NewsModel role = HttpUtil.toModel(newsJson, NewsModel.class);
        role = newsService.save(role);

        // --->
        newsJson = HttpUtil.toJson(role);
        PrintWriter writer = resp.getWriter();
        writer.write(newsJson);
    }
}
