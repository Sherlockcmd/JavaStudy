package com.easy.web.filter;

import com.easy.web.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "login", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoginFilter.doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //像要完成login的请求还有一些静态资源是不需要判断是否已经登录
        String uri = request.getRequestURI();
        System.out.println("uri: " + uri);
        // uri: /login.jsp
        // uri: /static/layui/layui.js
        // uri: /user
        // /user?method=login
        // /user
        String method = request.getParameter("method");
        // null  null.方法()
        if (uri.startsWith("/static")
                || uri.equals("/login.jsp")
                || uri.equals("/fail.jsp")
                || uri.equals("/verifyCode")
                || uri.equals("/user") && "login".equals(method)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login.jsp");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
