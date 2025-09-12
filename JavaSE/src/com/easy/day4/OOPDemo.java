package com.easy.day4;

import org.junit.Test;

public class OOPDemo {
    @Test
    public void test1() {
        Student student = new Student();
        student.setId(1);
        //'age' has private access in 'com. easy. day4.Student'
        //student.age = 23;
        student.setAge(223);
        int age = student.getAge();
        System.out.println(age);
        System.out.println(student.getAge());
    }

    @Test
    public void test2() {
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("zhangsan");
        student1.setAge(23);
        student1.setGender("男");

        Student student2 = new Student(2, "lisi", 23, "女");
        System.out.println(student2);
    }

    @Test
    public void test44() {
        Cal cal = new Cal(3, 5);
        int result1 = cal.add();
        System.out.println(result1);
        System.out.println(cal.add());
    }
}
