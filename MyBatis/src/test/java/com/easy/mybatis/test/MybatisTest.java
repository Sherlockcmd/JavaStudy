package com.easy.mybatis.test;

import com.easy.mybatis.pojo.Student;
import com.easy.mybatis.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testSelectById() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建 SqlSessionFactory    Session:会话 (连接数据库后就建立了一次会话，有了会话就可以操作数据库)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行sql语句
        Student student = sqlSession.selectOne("student.selectById", 1);
        System.out.println(student);
    }

    @Test
    public void testSelectById2() throws IOException {
        Student student = MyBatisUtil.getSqlSession().selectOne("student.selectById", 1);
        System.out.println(student);
    }

    @Test
    public void testSelectAll() throws IOException {
        List<Student> students = MyBatisUtil.getSqlSession().selectList("student.selectAll");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void studentadd() throws IOException {
        Student student = new Student();
        student.setName("zhangsan5");
        student.setAge(18);
        student.setGender("男");
        student.setBanjiId(3);
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
       int count = sqlSession.insert("student.add",student);
       System.out.println(count);

       sqlSession.commit();
       sqlSession.close();
    }

    @Test
    public void studentupdate() throws IOException {
        Student student = new Student();
        student.setId(3);
        student.setName("zhangsan5");
        student.setAge(20);
        student.setGender("女");
        student.setBanjiId(3);
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int count = sqlSession.update("student.update", student);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void studentdeleteById() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int count = sqlSession.delete("student.deleteById", 6);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void studentselectByPage() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Map<String,Integer> map = new HashMap<String,Integer>();
        int pageNo=1;
        int pageSize=3;
        int offset=(pageNo-1)*pageSize;
        map.put("offset", offset);
        map.put("pageSize",pageSize);
        List<Student> list = sqlSession.selectList("student.selectByPage",map);
        for(Student student : list){
            System.out.println(student);
        }
    }



}
