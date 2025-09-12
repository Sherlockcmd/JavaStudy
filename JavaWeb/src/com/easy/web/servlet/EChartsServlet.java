package com.easy.web.servlet;

import com.easy.web.pojo.Banji;
import com.easy.web.pojo.vo.BanjiCountVO;
import com.easy.web.service.IBanjiService;
import com.easy.web.service.impl.BanjiServiceImpl;
import com.easy.web.util.JDBCUtil;
import com.easy.web.util.JSONUtil;
import com.easy.web.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/echarts")
public class EChartsServlet extends HttpServlet {
    private IBanjiService banjiService = new BanjiServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("EChartsServlet.service");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<BanjiCountVO> list = new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT b.`name`,COUNT(*) AS value\n" +
                    "FROM student AS s INNER JOIN banji AS b\n" +
                    "ON s.banji_id=b.id \n" +
                    "GROUP BY b.id";
            preparedStatement = connection.prepareStatement(sql);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int value = resultSet.getInt("value");
                BanjiCountVO banjiCountVO = new BanjiCountVO(name, value);
                list.add(banjiCountVO);
            }
            for (BanjiCountVO banjiCountVO : list) {
                System.out.println(banjiCountVO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //6、关闭连接
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }

        JSONUtil.toJSON(resp, Result.ok(list));
    }
}
