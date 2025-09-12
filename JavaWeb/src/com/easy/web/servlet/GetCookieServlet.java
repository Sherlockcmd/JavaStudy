package com.easy.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GetCookieServlet.service");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("name: " + cookie.getName() + ", value: " + cookie.getValue());
        }
    }
}
