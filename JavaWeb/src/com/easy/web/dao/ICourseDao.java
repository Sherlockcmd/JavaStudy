package com.easy.web.dao;

import com.easy.web.pojo.Course;

import java.util.List;

public interface ICourseDao {
    List<Course> selectByPage(Integer offset, Integer limit);
    int selectTotalCount();

    void deleteById(int id);

    void add(Course course);

    Course selectById(int id);

    void update(Course course);
}
