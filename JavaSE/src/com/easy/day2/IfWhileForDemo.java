package com.easy.day2;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class IfWhileForDemo {
    @Test
    public void test1() {
        if (3 >= 5) {
            System.out.println("3 >= 5");
        } else  {
            System.out.println("3 < 5");
        }
    }


    /*>=90   <=100      优秀
    >=80    <90       良好
    >=70    <80       一般
    >=60    <70      及格
    <60              不及格*/
    @Test
    public void test2() {
        //int score = 48;
        //通过Scanner可以实现从控制台输入信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩：");
        int score = scanner.nextInt();
        //卫操作1
        if (score < 0 || score > 100) {
            System.out.println("这是非法输入");
            return;
        }
        //卫操作2

        if (score >= 90 && score <= 100) {
            System.out.println("优秀");
        } else if (score >= 80 && score < 90) {
            System.out.println("良好");
        } else if (score >= 70 && score < 80) {
            System.out.println("一般");
        } else if (score >= 60 && score < 70) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
    }

    @Test
    public void test3() {
        int num1 = 3;
        int num2 = 5;
        int max = 0;
        if (num1 >= num2) {
            max = num1;
        } else {
            max = num2;
        }
        System.out.println(max);
        System.out.println("max: " + max);

        int max1 = num1 >= num2 ? num1 : num2;
        System.out.println(max1);
    }

    @Test
    public void test7() {
        int age = 28;
        //豆豆加加
        System.out.println("我的年龄是23岁");
        System.out.println("我的年龄是" + age + "岁");
        System.out.println(10 + 20 + "" + 30);//"3030"
        System.out.println("" + 10 + 20 + 30);//"102030"
    }

    @Test
    public void test6() {
        int i = 1;
        while (i <= 5) {
            System.out.println("HelloWorld");
            i++;
        }
    }

    @Test
    public void test8() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("HelloWorld");
        }
    }

    //累加思想（1+2+3+... + 100）
    @Test
    public void test9() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            //sum = sum + i;
            sum += i;
            System.out.println("sum: " + sum);
        }
        System.out.println("sum: " + sum);
    }

    //统计思想，数一下符合条件的有多少个（计算1-100以内7的倍数的个数）
    @Test
    public void test10() {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("count: " + count);
    }

    @Test
    public void test44() {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }
    }

    @Test
    public void test45() {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }
    }

    @Test
    public void test46() {
        //i,j,k
        for (int i = 1; i <= 5; i++) {
            System.out.println("i: " + i);
            for (int j = 1; j <= 5; j++) {
                if (j == 3) {
                    break;
                }
                System.out.println("j: " + j);
            }
        }
    }

    @Test
    public void test88() {
        Scanner scanner = new Scanner(System.in);
        //Params parameters
        Random random = new Random();
        //int value between zero (inclusive) and bound (exclusive)
        //[0,100)+1
        //[1,101)
        int num = random.nextInt(100);
        System.out.println(num);
        while (true) {
            System.out.println("猜吧");
            int guess = scanner.nextInt();
            if (guess == num) {
                System.out.println("恭喜你，猜对了");
                break;
            }

            if (guess > num) {
                System.out.println("太大了");
            } else {
                System.out.println("太小了");
            }
        }
        System.out.println("IfWhileForDemo.test88");
    }

//    ****
//    ****
//    ****
    @Test
    public void test81() {
        //****
        for (int i = 1; i <= 4; i++) {
            System.out.print("*");
        }
        System.out.println();
        //*
        //*
        //*
        for (int i = 1; i <= 3; i++) {
            System.out.println("*");
        }
    }

    @Test
    public void test82() {
        for (int i = 1; i <= 3; i++) {
            //i=1: 代表打印第一行
            //i=2: 代表打印第二行
            //i=3: 代表打印第三行
            for (int j = 1; j <= 4; j++) {
                //j代表这一行打印多少个
                System.out.print("*");
            }
            //打印完这一行之后换行
            System.out.println();
        }
    }

//    *
//    **
//    ***
//    ****
//    *****
    @Test
    public void test72() {
        //i=1  j=1
        //i=2  j=2
        //i=3  j=3
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    public void test73() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                //System.out.print("2*7=14\t");
                System.out.print(j+"*"+i+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }

    //输入月份判断天数：
    //1、3、5、7、8、10、12  -------- 31天
    //4、6 、9、11--------------------30天
    //2----------------------------------28/29天
    @Test
    public void test89() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
                System.out.println("31天");
                break;
            case 2:
                System.out.println("28/29天");
                break;
            case 3:
                System.out.println("31天");
                break;
            case 4:
                System.out.println("30天");
                break;
            case 5:
                System.out.println("31天");
                break;
            case 6:
                System.out.println("30天");
                break;
            case 7:
                System.out.println("31天");
                break;
        }
    }

    @Test
    public void test80() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30天");
                break;
            case 2:
                System.out.println("请输入年份：");
                int year = scanner.nextInt();
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    System.out.println("29天");
                } else {
                    System.out.println("28天");
                }
                break;
            default:
                System.out.println("default");
        }
    }

    // Shift+Enter
    //能被4整除，但是不能被100整除    ||   能被400整除
    @Test
    public void test889() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        // if (() || ())
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("是闰年");
        } else {
            System.out.println("不是闰年");
        }
    }

//     >=90    <=100    优秀
//    >=80    <90        良好
//    >=70    <80         一般
//    >=60    <70         及格
//    <60                     不及格
    @Test
    public void test65() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩：");
        int score = scanner.nextInt();
        switch (score / 10) {
            case 9:
            case 10:
                System.out.println("优秀");
                break;
            case 8:
                System.out.println("良好");
                break;
            case 7:
                System.out.println("一般");
                break;
            case 6:
                System.out.println("及格");
                break;
            default:
                System.out.println("不及格");
                break;
        }
    }

    @Test
    public void test77() {
        int num1 = 3;
        int num2 = 5;
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

    }


}
