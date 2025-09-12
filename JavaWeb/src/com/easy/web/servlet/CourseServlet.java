package com.easy.web.servlet;

import com.easy.web.dao.IStudentDao;
import com.easy.web.dao.impl.StudentDaoImpl;
import com.easy.web.pojo.Course;
import com.easy.web.service.ICourseService;
import com.easy.web.service.impl.CourseServiceImpl;
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


@WebServlet("/course")
public class CourseServlet extends HttpServlet {
    private ICourseService courseService = new CourseServiceImpl();
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
        System.out.println("CourseServlet.update");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String credit = req.getParameter("credit");
        Course course = new Course(Integer.parseInt(id), name, Integer.parseInt(credit));
        courseService.update(course);
        JSONUtil.toJSON(resp, Result.ok("编辑成功"));
    }

    private void selectById(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("CourseServlet.selectById");
        String id = req.getParameter("id");
        Course course = courseService.selectById(Integer.parseInt(id));
        JSONUtil.toJSON(resp, Result.ok(course));
    }

    private void deleteAll(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("CourseServlet.deleteAll");
        String[] ids = req.getParameterValues("ids[]");
        courseService.deleteAll(ids);
        JSONUtil.toJSON(resp, Result.ok("删除成功"));
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("CourseServlet.add");
        String name = req.getParameter("name");
        String credit = req.getParameter("credit");
        Course course = new Course(name, Integer.parseInt(credit));
        courseService.add(course);
        JSONUtil.toJSON(resp, Result.ok("添加成功"));
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("CourseServlet.deleteById");
        String id = req.getParameter("id");
        courseService.deleteById(Integer.parseInt(id));

        //发送ajax请求，返回json格式数据：Result
        //Result result = new Result(0, "删除成功");
        //Result result = Result.ok("删除成功");
        /*resp.setContentType("text/html;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), Result.ok("删除成功"));*/
        JSONUtil.toJSON(resp, Result.ok("删除成功"));
    }

    // /course?method=selectByPage&page=1&limit=10
    // /course?method=selectByPage&page=2&limit=20
    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("CourseServlet.selectByPage");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        PageResult<Course> pageResult = courseService.selectByPage(Integer.parseInt(page), Integer.parseInt(limit));

        resp.setContentType("text/html;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), pageResult);
    }
}
