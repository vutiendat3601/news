package com.dv.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dv.constant.SystemConstant;
import com.dv.model.NewsModel;
import com.dv.service.NewsService;
import com.dv.util.FormUtil;

@WebServlet(urlPatterns = { "/admin-news" })
public class NewsController extends HttpServlet {

    @Inject
    NewsService newsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // <---
        NewsModel news = FormUtil.toModel(req, NewsModel.class);
        Integer offset = (news.getPage() - 1) * news.getMaxPageItem();
        news.setTotalItem(newsService.getTotalItem());
        news.setTotalPage((int) Math.ceil((double) news.getTotalItem() / news.getMaxPageItem()));
        List<NewsModel> newses = newsService.findAll(news.getMaxPageItem(), offset);

        // --->
        news.setResultList(newses);
        req.setAttribute(SystemConstant.MODEL, news);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/news/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
