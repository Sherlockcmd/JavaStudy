package com.easy.day3;

import org.junit.Test;

public class OOPDemo {
    @Test
    public void test1() {
        int num = 3;
        //student1:变量，对象，引用
        Student student1 = new Student();
        //对象.属性
        student1.id = 1;
        student1.name = "zhangsan";
        student1.age = 23;
        student1.gender = "男";
        System.out.println("id: " + student1.id + " name: " + student1.name);
        String info1 = student1.getInfo();
        System.out.println(info1);
        System.out.println(student1.toString());
        //当直接打印对象的时候，默认就是调用：对象.toString();
        System.out.println(student1);

        Student student2 = new Student();
        //对象.属性
        student2.id = 2;
        student2.name = "lisi";
        student2.age = 23;
        student2.gender = "女";
        System.out.println("id: " + student1.id + " name: " + student1.name);
        String info2 = student2.getInfo();
        System.out.println(info2);
        System.out.println(student2.toString());
        System.out.println(student2);
    }

    @Test
    public void test2() {
        Student student = new Student();
        System.out.println(student.id);//0
        System.out.println(student.name);//null

    }

    @Test
    public void test3() {
        int[] array1 = new int[3];
        boolean[] array2 = new boolean[3];
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        //增强的for循环
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test4() {
        Student student = null;
        System.out.println(student);//null
        //NullPointerException
        // null.属性  null.方法()
        System.out.println(student.id);
    }

    @Test
    public void test5() {
        Student student = new Student();
        student.id = 1;
        student.name = "zhangsan";
        student.age = 223;
        student.gender = "男";
        System.out.println("age: " + student.age + " name: " + student.name);
    }

}
