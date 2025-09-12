package com.easy.day1;

import org.junit.Test;

//大驼峰 名词
public class HelloWorld {

    //Console
    //main
    public static void main(String[] args) {
        //sout
        System.out.println("HelloWorld");
        //变量：variable
        //=赋值，把右边这个值赋值给左边这个变量
        int age = 23;
        age = 25;
        //常量：赋值之后值不能改变
        final int age2 = 21;
        //Cannot assign a value to final variable 'age2'
        //age2 = 24;

        int $num1$1 = 23;
    }

    //JUnit: Java Unit
    //Alt+Enter
    @Test
    public void test1() {
        //soutm
        int num = 23;
        boolean b1 = true;
        boolean b2 = false;

        char ch = 'a';
        System.out.println(ch);//a
        System.out.println(ch + 1);//97+1=98
        System.out.println(ch + 2);//97+2=99
        System.out.println((char)(ch + 1));//b
        System.out.println((char)(ch + 2));//c

        double d = 3.14;
        int n = (int)d;
        System.out.println(n);//3
    }

    @Test
    public void test2() {
        System.out.println("Hello.test2");
        int num1 = 3;
        int num2 = 5;
        int result = num1 + num2;
        System.out.println(result);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2);
        System.out.println(num1 / num2);

        System.out.println(8 / 2);//4
        System.out.println(8 % 2);//0
        System.out.println(8 / 5);//1
        System.out.println(8 % 5);//3
    }

    @Test
    public void test3() {
        int i = 1;
        i++; // ++i     i = i + 1
        System.out.println(i);//2
        System.out.println(i++);//2
        System.out.println(i);//3
        System.out.println(++i);//4
    }

    @Test
    public void test5() {
        System.out.println(3 >= 5);//false
        System.out.println(5 < 10);//true
        System.out.println(5 == 10);//false
        System.out.println(5 <= 10);//true
        int num1 = 3;
        int num2 = 5;
        System.out.println(num1 != num2);//true
    }

    //&&：两边的结果都是true，结果才是true
    //||：两边只要有一个是true，结果就是true
    @Test
    public void test51() {
        int score1 = 78;
        int score2 = 380;
        //=、>=、&& 优先级关系：>=、&&、=
        //比较运算符的优先级高于逻辑运算符
        //加了括号之后就不依赖默认优先级：()>比较运算符>逻辑运算符
        boolean result1 = (score1 >= 60) && (score2 >= 400);
        System.out.println(result1);
        boolean result2 = (score1 >= 60) || (score2 >= 400);
        System.out.println(result2);

        //短路
        int num1 = 3;
        int num2 = 5;
        //&&短路
        System.out.println(num1 < 0 && num1++ < num2);//false
        System.out.println(num1);//3
        System.out.println(num2);//5

        //||短路
        System.out.println(num1 > 0 || num1++ < num2);//true
        System.out.println(num1);//3
        System.out.println(num2);//5
    }


}
