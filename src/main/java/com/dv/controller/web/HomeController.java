package com.dv.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dv.model.CategoryModel;
import com.dv.service.CategoryService;

@WebServlet(urlPatterns = { "/homepage", "/login", "/dang-nhap" })
public class HomeController extends HttpServlet {

    @Inject
    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/home.jsp");
        if (action != null) {
            if (action.equals("login")) {
                requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            } else if (action.equals("logout")) {
                return;
            }
        } else {
            List<CategoryModel> categories = categoryService.findAll();
            req.setAttribute("categories", categories);
        }
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {

        }
    }
}
