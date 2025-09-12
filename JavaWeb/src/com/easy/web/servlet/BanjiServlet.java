package com.easy.web.servlet;

import com.easy.web.dao.IStudentDao;
import com.easy.web.dao.impl.StudentDaoImpl;
import com.easy.web.pojo.Banji;
import com.easy.web.service.IBanjiService;
import com.easy.web.service.impl.BanjiServiceImpl;
import com.easy.web.util.JSONUtil;
import com.easy.web.util.PageResult;
import com.easy.web.util.Result;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/banji")
public class BanjiServlet extends HttpServlet {
    private IBanjiService banjiService = new BanjiServiceImpl();
    private IStudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectByPage";
        }
        switch (method) {
            case "selectByPage":
                selectByPage(req, resp);
                break;
            case "deleteById":
                deleteById(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
            case "deleteAll":
                deleteAll(req, resp);
                break;
            case "selectById":
                selectById(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("BanjiServlet.update");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        Banji banji = new Banji(Integer.parseInt(id), name, address);
        banjiService.update(banji);
        JSONUtil.toJSON(resp, Result.ok("编辑成功"));
    }

    private void selectById(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("BanjiServlet.selectById");
        String id = req.getParameter("id");
        Banji banji = banjiService.selectById(Integer.parseInt(id));
        JSONUtil.toJSON(resp, Result.ok(banji));
    }

    private void deleteAll(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("BanjiServlet.deleteAll");
        String[] ids = req.getParameterValues("ids[]");
        banjiService.deleteAll(ids);
        JSONUtil.toJSON(resp, Result.ok("删除成功"));
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("BanjiServlet.add");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        Banji banji = new Banji(name, address);
        banjiService.add(banji);
        JSONUtil.toJSON(resp, Result.ok("添加成功"));
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("BanjiServlet.deleteById");
        String id = req.getParameter("id");
        banjiService.deleteById(Integer.parseInt(id));

        //发送ajax请求，返回json格式数据：Result
        //Result result = new Result(0, "删除成功");
        //Result result = Result.ok("删除成功");
        /*resp.setContentType("text/html;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), Result.ok("删除成功"));*/
        JSONUtil.toJSON(resp, Result.ok("删除成功"));
    }

    // /banji?method=selectByPage&page=1&limit=10
    // /banji?method=selectByPage&page=2&limit=20
    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("BanjiServlet.selectByPage");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        PageResult<Banji> pageResult = banjiService.selectByPage(Integer.parseInt(page), Integer.parseInt(limit));

        resp.setContentType("text/html;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), pageResult);
    }
}
