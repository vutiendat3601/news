package com.dv.controller.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dv.util.DBUtil;

@WebServlet(urlPatterns = { "/homepage" })
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = DBUtil.getConnection();
        if (connection != null) {
            System.out.println("SUCCESSFUL!!!");
        }
    }
}
