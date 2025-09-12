package com.easy.day7;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo {

    @Test
    public void test1() {
        //java.lang.ArithmeticException: / by zero
        //int num = 1 / 0;

        String str = null;
        //NullPointerException  null.方法()
        //System.out.println(str.length());

        try {
            // 需要检查的代码（可能会抛出异常，也可能不会抛出异常）
            FileInputStream fileInputStream = new FileInputStream("io.txt");
            System.out.println("11111");
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            //捕获异常之后处理异常
            e.printStackTrace();
        } finally {
            //一定会被执行的代码（不管异常抛不抛出都会执行）
            System.out.println("finally");
        }

        System.out.println("ExceptionDemo.test1");
    }

    @Test
    public void test2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test3() {
        try {
            show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void show() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    @Test
    public void test4() {
        try {
            FileInputStream fileInputStream = new FileInputStream("io.txt");
            fileInputStream.read();
        }  catch (FileNotFoundException e) {
            //Exception 'java. io. FileNotFoundException' has already been caught
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            System.out.println("finally");
        }
    }

    @Test
    public void test5() {
        try {
            quQian(800);
        } catch (MeiQianException e) {
            e.printStackTrace();
        }
    }

    public void quQian(double money) throws MeiQianException {
        if (money >= 1000) {
            throw new MeiQianException("钱不够了");
        }
        System.out.println("钱够了");
    }
}
