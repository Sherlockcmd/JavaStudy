package com.easy.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/ajax2")
public class Ajax2Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax2Servlet.service");
        String name = req.getParameter("name");
        //{exist: true, msg: '此用户已经存在，请更换一个'}
        //{exist: false, msg: '该用户可用'}
        Map<String, Object> map = new HashMap<>();
        if ("tom".equalsIgnoreCase(name)) {
            map.put("exist", true);
            map.put("msg", "此用户已经存在，请更换一个");
        } else {
            map.put("exist", false);
            map.put("msg", "该用户可用");
        }

        resp.setContentType("text/html;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(), map);
    }
}
