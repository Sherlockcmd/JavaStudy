package com.easy.day3;

//驼峰命名法
// String className  小驼峰
//实体类：和数据库中表一一映射
//类的内部、类的外部
public class Student {
    //属性
    int id;
    String name;
    int age;
    String gender;


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
