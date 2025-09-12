package com.easy.day4;

//驼峰命名法
// String className  小驼峰
//实体类：和数据库中表一一映射
//类的内部、类的外部
public class Student {
    //属性
    private int id;
    private String name;
    private int age;
    private String gender;

    //你不写java默认提供无参构造方法
    public Student() {
        System.out.println("Student.Student1");
    }

    //有参构造方法
    public Student(int id, String name, int age, String gender) {
        System.out.println("Student.Student2");
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //public get/set方法
    public void setAge(int age) {
        //Variable is already assigned to this value
        //The value 'age' assigned to 'age' is never used
        //就近原则
        //age = age;
        //this代表当前类对象
        if (age < 0 || age >125) {
            //抛出异常
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //方法
    public String getInfo() {
        //String str = "[Student: id=1,name=zhangsan,age=23,gender=男]";
        String str = "[Student: id="+id+",name="+name+",age="+age+",gender="+gender+"]";
        return str;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
