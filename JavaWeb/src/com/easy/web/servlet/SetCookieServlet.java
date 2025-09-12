package com.easy.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SetCookieServlet.service");
        Cookie cookie1 = new Cookie("goods", "IPhone");
        Cookie cookie2 = new Cookie("name", "Iphone");
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
