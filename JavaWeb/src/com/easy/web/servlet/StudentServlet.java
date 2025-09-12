package com.easy.web.servlet;

import com.easy.web.dao.IStudentDao;
import com.easy.web.dao.impl.StudentDaoImpl;
import com.easy.web.pojo.Student;
import com.easy.web.pojo.User;
import com.easy.web.service.IStudentService;
import com.easy.web.service.impl.StudentServiceImpl;
import com.easy.web.util.JDBCUtil;
import com.easy.web.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


// http://localhost:8080/index.jsp
// http://localhost:8080/student
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    //private IStudentDao studentDao = new StudentDaoImpl();
    private IStudentService studentService = new StudentServiceImpl();

    //访问servlet的时候默认访问service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setCharacterEncoding("UTF-8");
        /*HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }*/
        //System.out.println("StudentServlet.service");
        //http://localhost:8080/student?method=selectAll
        //http://localhost:8080/student?method=deleteById&id=2
        //http://localhost:8080/student?method=add
        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectByPage";
        }
        switch (method) {
            case "selectAll":
                selectAll(req, resp);
                break;
            case "selectByPage":
                selectByPage(req, resp);
                break;
            case "deleteById":
                deleteById(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
            case "toAdd":
                toAdd(req, resp);
                break;
            case "toUpdate":
                toUpdate(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
        }
    }

    // /student?method=selectByPage&pageNo=1&pageSize=10
    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentServlet.selectByPage");
        String pageNo = req.getParameter("pageNo");
        String pageSize = req.getParameter("pageSize");
        if (pageNo == null || pageNo.equals("")) {
            pageNo = "1";
        }
        if (pageSize == null ||pageSize.equals("")) {
            pageSize = "5";
        }
        PageInfo pageInfo = studentService.selectByPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        System.out.println(pageInfo);

        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("/student_list.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("StudentServlet.update");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        Student student = new Student(Integer.parseInt(id), name, Integer.parseInt(age), gender);
        studentService.update(student);

        resp.sendRedirect("/student");
    }

    private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentServlet.toUpdate");
        String id = req.getParameter("id");
        Student student = studentService.selectById(Integer.parseInt(id));

        req.setAttribute("student", student);
        req.getRequestDispatcher("/student_update.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentServlet.toAdd");
        req.getRequestDispatcher("/student_add.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("StudentServlet.add");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        Student student = new Student(name, Integer.parseInt(age), gender);
        studentService.add(student);

        resp.sendRedirect("/student");
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("StudentServlet.deleteById");
        String id = req.getParameter("id");// "2"
        studentService.deleteById(Integer.parseInt(id));

        //重定向  302
        resp.sendRedirect("/student");
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentServlet.selectAll");
        List<Student> list = studentService.selectAll();

        // 把list里面数据放到req
        req.setAttribute("list", list);
        //req.setAttribute("pageNo", 3);
        //转发到student_list.jsp页面进行展示
        req.getRequestDispatcher("/student_list2.jsp").forward(req, resp);
    }


}
