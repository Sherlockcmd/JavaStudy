package com.easy.web.service;

import com.easy.web.pojo.Course;
import com.easy.web.util.PageResult;

public interface ICourseService {
    PageResult<Course> selectByPage(Integer page, Integer limit);

    void deleteById(int id);

    void add(Course course);

    void deleteAll(String[] ids);

    Course selectById(int id);

    void update(Course course);
}
