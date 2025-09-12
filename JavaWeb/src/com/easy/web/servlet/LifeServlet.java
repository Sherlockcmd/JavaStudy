package com.easy.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/life")
public class LifeServlet extends HttpServlet {

    public LifeServlet() {
        System.out.println("LifeServlet.LifeServlet");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("LifeServlet.init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeServlet.service");
    }

    @Override
    public void destroy() {
        System.out.println("LifeServlet.destroy");
    }
}
