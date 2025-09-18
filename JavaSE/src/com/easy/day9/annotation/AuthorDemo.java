package com.easy.day9.annotation;


import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

@Author(name = "zhangsan",age = 23,value = {"男","女"})
public class AuthorDemo {


    @Author(name = "list",age = 25,value = {"男"})
    public void add(){

    }

    @Test
    public void test1() throws NoSuchMethodException {
        Class<AuthorDemo> authorDemoClass = AuthorDemo.class;
        Author annotation = authorDemoClass.getAnnotation(Author.class);
        System.out.println(annotation.name());
        System.out.println(annotation.age());
        System.out.println(annotation.value()[0]);
        System.out.println(Arrays.toString(annotation.value()));

        Method method = authorDemoClass.getMethod("add");
        Author annotation1 = method.getAnnotation(Author.class);
        System.out.println(annotation1.name());
        System.out.println(annotation1.age());
        System.out.println(Arrays.toString(annotation1.value()));



    }


}
