package com.easy.day9;

import org.junit.Test;

import java.lang.invoke.VarHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    @Test
    public void test1() throws ClassNotFoundException {
        //获取对象的字节码文件
        //1.class.forname(类路径);
        Class clazz1 = Class.forName("com.easy.day9.Student");

        //2.类型.class
        Class clazz2 = Student.class;

        //3.对象.getclass();
        Student student= new Student();
        Class clazz3 = student.getClass();


        System.out.println(clazz1==clazz2);
        System.out.println(clazz3==clazz1);
        System.out.println(clazz3==clazz2);
    }

    //获取构造方法
    @Test
    public void test2() throws ClassNotFoundException {
         Class clazz1 = Student.class;
        Constructor[] constructors = clazz1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
            System.out.println(constructor.getModifiers());
            System.out.println(constructor.getName());
        }
    }

    //访问构造方法并使用
    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz1 = Student.class;
        //拿到构造方法

        Constructor constructor = clazz1.getDeclaredConstructor(Integer.class, String.class, Integer.class, String.class);

        //一定要访问私有变量要做声明
        constructor.setAccessible(true);
        //正常的new一个对象：Student student = new Student(1,"zhangshan",23,"男");
        //用反射new一个对象：
     Student student = (Student) constructor.newInstance(1,"zhangshan",23,"男");
       System.out.println(student);

    }

    //访问普通方法并使用
    @Test
    public void test4() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //正常调用普通方法：
        //Student student = new Student();
        //student.setName("张三")

        //反射调用普通方法
        Class clazz1 = Student.class;
        Constructor constructor = clazz1.getConstructor();
        Student student = (Student) constructor.newInstance();
        Method method = clazz1.getDeclaredMethod("setName", String.class);
        method.setAccessible(true);
        method.invoke(student,"张三");
        Method method1 = clazz1.getMethod("getName");
        System.out.println(method1.invoke(student));
        System.out.println(student);
        System.out.println(student.getName());


    }





}
