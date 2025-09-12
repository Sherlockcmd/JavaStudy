package com.easy.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax1")
public class Ajax1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax1Servlet.doGet");
        String name = req.getParameter("name");
        System.out.println(name);

        resp.setContentType("text/html;charset=UTF-8");
        // {"name":"李四1","age":23}
        resp.getWriter().write("{\"name\":\"李四1\",\"age\":23}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax1Servlet.doPost");
        String name = req.getParameter("name");
        System.out.println(name);

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("{\"name\":\"李四2\",\"age\":23}");
    }
}
