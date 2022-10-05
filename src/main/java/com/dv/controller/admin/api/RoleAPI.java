package com.dv.controller.admin.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dv.model.RoleModel;
import com.dv.service.RoleService;
import com.dv.service.impl.RoleServiceImpl;

@WebServlet(urlPatterns = { "/api-role" })
public class RoleAPI extends HttpServlet {

    RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        List<RoleModel> roles = roleService.findAll();
        PrintWriter writer = resp.getWriter();
        for (RoleModel role : roles) {
            writer.write(role.getName());
            writer.write(role.getCode());
        }
    }
}
