package com.easy.day9.generic;

import com.easy.day9.Student;
import com.easy.day9.Teacher;
import org.junit.Test;

public class GenericDemo2 {
    public Student add(Student student, Teacher teacher) {
        return student;
    }

    public <K,T> K add(K k,T t){
        return k;
    }

    @Test
    public void test() {
        System.out.println(add("abc", 1.0));
    }

}
