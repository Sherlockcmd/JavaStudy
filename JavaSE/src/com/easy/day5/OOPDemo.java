package com.easy.day5;

import org.junit.Test;

import java.io.InputStream;

public class OOPDemo {

    @Test
    public void test1() {
        String s = "abc";
        InputStream inputStream = null;
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("张三");
        student1.setAge(23);
        student1.setGender("男");
        student1.setClassName("Java01");
        System.out.println(student1);
        student1.show();
        student1.study();

        Student student2 = new Student(2, "lisi", 23, "男", "Java01");
        System.out.println(student2);
        student2.study();
    }

    @Test
    public void test2() {
        Student student = new Student(2, "lisi", 23, "男", "Java01");
        //com.easy.day5.Student@d7b1517
        System.out.println(student);
        System.out.println(student.toString());
        //student.study();
        student.show();
    }

    void show(int a, char b, double c){}
    //'show(int, char, double)' is already defined in 'com. easy. day5.OOPDemo'
    //void show(int x, char y, double z){}
}
