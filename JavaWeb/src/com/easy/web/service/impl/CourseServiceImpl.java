package com.easy.web.service.impl;

import com.easy.web.dao.ICourseDao;
import com.easy.web.dao.impl.CourseDaoImpl;
import com.easy.web.pojo.Course;
import com.easy.web.service.ICourseService;
import com.easy.web.util.MD5Util;
import com.easy.web.util.PageResult;

import java.util.List;

public class CourseServiceImpl implements ICourseService {
    private ICourseDao courseDao = new CourseDaoImpl();

    @Override
    public PageResult<Course> selectByPage(Integer page, Integer limit) {
        int offset = (page - 1) * limit;
        List<Course> list = courseDao.selectByPage(offset, limit);
        int totalCount = courseDao.selectTotalCount();

        return new PageResult<>(0, "", totalCount, list);
    }

    @Override
    public void deleteById(int id) {
        courseDao.deleteById(id);
    }

    @Override
    public void add(Course course) {
        //user.setPassword(MD5Util.MD5Encode(user.getPassword + MD5Util.SALT));
        courseDao.add(course);
    }

    @Override
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            courseDao.deleteById(Integer.parseInt(id));
        }
    }

    @Override
    public Course selectById(int id) {
        return courseDao.selectById(id);
    }

    @Override
    public void update(Course course) {
        courseDao.update(course);
    }
}
