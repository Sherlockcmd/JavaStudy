package com.easy.web.service;

import com.easy.web.pojo.Student;
import com.easy.web.util.PageInfo;

import java.util.List;

public interface IStudentService {
    List<Student> selectAll();
    void deleteById(Integer id);
    void add(Student student);
    Student selectById(Integer id);
    void update(Student student);
    PageInfo selectByPage(int pageNo, int pageSize);
}
