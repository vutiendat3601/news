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

import com.dv.model.CategoryModel;
import com.dv.service.CategoryService;
import com.dv.util.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-category" })
public class CategoryAPI extends HttpServlet {

    @Inject
    CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        // <---
        List<CategoryModel> categories = categoryService.findAll();

        // --->
        String categoryJson = HttpUtil.toJson(categories);
        PrintWriter writer = resp.getWriter();
        writer.write(categoryJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        // <---
        String categoryJson = HttpUtil.toJson(req);
        CategoryModel category = HttpUtil.toModel(categoryJson, CategoryModel.class);
        category = categoryService.save(category);

        // --->
        categoryJson = HttpUtil.toJson(category);
        PrintWriter writer = resp.getWriter();
        writer.write(categoryJson);
    }
}
