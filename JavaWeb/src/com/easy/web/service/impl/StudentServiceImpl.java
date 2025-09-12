package com.easy.web.service.impl;

import com.easy.web.dao.IStudentDao;
import com.easy.web.dao.impl.StudentDaoImpl;
import com.easy.web.pojo.Student;
import com.easy.web.service.IStudentService;
import com.easy.web.util.PageInfo;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }

    @Override
    public void deleteById(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public Student selectById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public PageInfo<Student> selectByPage(int pageNo, int pageSize) {
        //第一条sql：查询当前页的数据
        int offset = (pageNo - 1) * pageSize;
        List<Student> list = studentDao.selectByPage(offset, pageSize);
        //第二条：查询总的数量
        int totalCount = studentDao.selectTotalCount();
        int totalPage = (int)Math.ceil((double)totalCount / pageSize);
        PageInfo<Student> pageInfo = new PageInfo(list, totalPage, pageNo, pageSize);
        return pageInfo;
    }

    public static void main(String[] args) {
        int totalCount = 12;
        int pageSize = 5;
        System.out.println(totalCount / pageSize);//2
        System.out.println((double)totalCount / pageSize);//2.4
        System.out.println(Math.ceil((double)totalCount / pageSize));//3.0
        int totalPage = (int)Math.ceil((double)totalCount / pageSize);//3.0
        System.out.println(totalPage);//3
    }
}
