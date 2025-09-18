package com.easy.day9.generic;

import com.easy.day9.Student;
import com.easy.day9.Teacher;
import org.junit.Test;

public class BaseDao<T> {
    public void add(T t) {

    }
    public void update(T t) {

    }

    @Test
    public void test() {
        Student student = new Student();
        BaseDao<Student> baseDao1 = new BaseDao<>();
        baseDao1.add(student);
        baseDao1.update(student);


        Teacher teacher = new Teacher();
        BaseDao<Teacher> baseDao2=new BaseDao<>();
        baseDao2.add(teacher);
        baseDao2.update(teacher);

    }



}
