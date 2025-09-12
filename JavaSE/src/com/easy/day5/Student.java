package com.easy.day5;


public class Student extends Person {
    private String className;
    //private String name = "lll";

    public Student() {
        super();//new Person()
        System.out.println("Student.Student1");
    }

    //Java里面new子类对象一定首先new出父类对象
    public Student(int id, String name, int age, String gender, String className) {
        super(id, name, age, gender);//new Person(int id, String name, int age, String gender)
        this.className = className;
        System.out.println("Student.Student2");
    }

    @Override
    public void show() {
        System.out.println("Student.show");
    }

    public void study() {
        System.out.println(className + "班的" + name + "正在学习");
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    //重写 覆盖
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
