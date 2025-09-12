package com.easy.web.dao;

import com.easy.web.pojo.Student;

import java.util.List;

//接口里面列出来的是能提供的所有的功能的列表
public interface IStudentDao {
    List<Student> selectAll();
    void deleteById(Integer id);
    void add(Student student);
    Student selectById(Integer id);
    void update(Student student);

    List<Student> selectByPage(int offset, int pageSize);

    int selectTotalCount();
}
