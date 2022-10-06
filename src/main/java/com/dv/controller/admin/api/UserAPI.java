package com.dv.controller.admin.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dv.model.UserModel;
import com.dv.service.UserService;
import com.dv.util.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-user" })
public class UserAPI extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        writer.write("CHua lam gi car");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        // <---
        String userJson = HttpUtil.toJson(req);
        UserModel user = HttpUtil.toModel(userJson, UserModel.class);
        user = userService.save(user);

        // --->
        userJson = HttpUtil.toJson(user);
        PrintWriter writer = resp.getWriter();
        writer.write(userJson);
    }
}
