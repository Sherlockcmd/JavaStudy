package com.easy.day6;

public class Student {
    //属性、成员变量、实例变量、非静态属性
    public int id;
    private String name;

    //属性、静态变量
    public static String country = "中";

    //方法、成员方法、实例方法、非静态方法
    public void show() {
        System.out.println("Student.show");
        System.out.println(this.id);
    }

    //方法、静态方法
    public static void print() {
        System.out.println("Student.print");
        //Non-static field 'name' cannot be referenced from a static context
        //System.out.println(name);
        System.out.println(country);
        //System.out.println(this.id);
    }
}
