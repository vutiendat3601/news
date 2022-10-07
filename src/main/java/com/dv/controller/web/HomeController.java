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
import com.dv.model.UserModel;
import com.dv.service.CategoryService;
import com.dv.service.UserService;
import com.dv.util.FormUtil;
import com.dv.util.SessionUtil;

@WebServlet(urlPatterns = { "/homepage", "/login", "/dang-nhap" })
public class HomeController extends HttpServlet {

    @Inject
    private CategoryService categoryService;

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        RequestDispatcher requestDispatcher = null;
        if (action != null) {
            if (action.equals("login")) {
                requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            } else if (action.equals("logout")) {
            }
        } else {
            requestDispatcher = req.getRequestDispatcher("/views/web/home.jsp");
            List<CategoryModel> categories = categoryService.findAll();
            req.setAttribute("categories", categories);
        }
        if (requestDispatcher != null) {
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            if (action.equals("login")) {
                UserModel user = FormUtil.toModel(req, UserModel.class);
                user = userService.findByUsernameAndPasswordAndStatus(user.getUsername(), user.getPassword(), 1);
                if (user != null) {
                    SessionUtil session = SessionUtil.getInstance();
                    session.setValue(req, "user", user);

                    // Filter role
                    if (user.getRole().getCode().equals("USER")) {
                        resp.sendRedirect(req.getContextPath() + "/homepage");
                    } else if (user.getRole().getCode().equals("ADMIN")) {
                        resp.sendRedirect(req.getContextPath() + "/admin-home");
                    }
                } else {
                    System.err.println("no user found");
                    resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
                }
            }
        }
    }
}
