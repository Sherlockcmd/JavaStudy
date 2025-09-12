package com.easy.web.servlet;

import com.easy.web.pojo.User;
import com.easy.web.service.IUserService;
import com.easy.web.service.impl.UserServiceImpl;
import com.easy.web.util.JSONUtil;
import com.easy.web.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserServlet.service");
        //req.setCharacterEncoding("UTF-8");
        /*HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }*/

        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectByPage";
        }
        switch (method) {
            case "login":
                login(req, resp);
                break;
            case "logout":
                logout(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("UserServlet.logout");
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        resp.sendRedirect("/login.jsp");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("UserServlet.login");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        //1.先判断验证码是否正确
        //2.验证码错误，返回一个错误提示信息
        //3.验证码正确，再验证用户名和密码是否正确
        HttpSession session = req.getSession();
        String codeInSession = (String) session.getAttribute("codeInSession");
        if (!codeInSession.equalsIgnoreCase(code)) {
            JSONUtil.toJSON(resp, Result.error("验证码错误"));
            return;
        }

        User user = userService.login(name, password);
        if (user == null) {
            JSONUtil.toJSON(resp, Result.error("用户名或密码错误"));
        } else {
            session.setAttribute("user", user);
            JSONUtil.toJSON(resp, Result.ok("登录成功"));
        }

        /*if (user == null) {//失败
            resp.sendRedirect("/fail.jsp");
        } else {//成功
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            resp.sendRedirect("/");
        }*/
    }
}
