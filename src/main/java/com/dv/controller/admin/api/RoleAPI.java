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

import com.dv.model.RoleModel;
import com.dv.service.RoleService;
import com.dv.util.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-role" })
public class RoleAPI extends HttpServlet {
    
    @Inject
    RoleService roleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        // <---
        List<RoleModel> roles = roleService.findAll();

        // --->
        String roleJson = HttpUtil.toJson(roles);
        PrintWriter writer = resp.getWriter();
        writer.write(roleJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        // <---
        String roleJson = HttpUtil.toJson(req);
        RoleModel role = HttpUtil.toModel(roleJson, RoleModel.class);
        role = roleService.save(role);

        // --->
        roleJson = HttpUtil.toJson(role);
        PrintWriter writer = resp.getWriter();
        writer.write(roleJson);
    }
}
