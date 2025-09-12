package com.easy.day6;

import org.junit.Test;

import java.util.Arrays;

public class StringDemo {
    @Test
    public void test1() {
        //"abc"双引号直接括起来的字符串：字符串常量
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "abc";
        System.out.println(str1 == str2);//false
        System.out.println(str1 == str3);//true
        System.out.println(str2 == str2);//true

        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true
        System.out.println(str2.equals(str3));//true

    }

    @Test
    public void test2() {
        String str = "java AndroidA";
        System.out.println(str.length());//13
        char[] chars = str.toCharArray();
        char ch = str.charAt(5);//A
        System.out.println(ch);
        System.out.println(str.indexOf('A'));//5
        System.out.println(str.indexOf('X'));//-1 找不到返回-1
        System.out.println(str.indexOf('A', 6));//12
        System.out.println(str.indexOf("And"));//5
        System.out.println(str.lastIndexOf('A'));//12
    }

    @Test
    public void test3() {
        String str1 = "java";
        String str2 = "Java";
        System.out.println(str1.equals(str2));//false
        System.out.println(str1.equalsIgnoreCase(str2));//true

        String str = "java AndroidA";
        System.out.println(str.contains("And"));//true
        System.out.println(str.startsWith("java"));//true
        //offset:偏移
        System.out.println(str.startsWith("And", 5));//true
        System.out.println(str.endsWith("oidA"));//true
        System.out.println(str.isEmpty());//false
        //"":空字符串，也是一个对象   ' '
        System.out.println("".isEmpty());//true
        char ch = ' ';
    }

    @Test
    public void test44() {
        // ""
        //String str = "java And";
        char[] array = {'j', 'a', 'v', 'a', ' ', 'A', 'n', 'd'};
        String str = new String(array);
        System.out.println(str);//java And
        char[] chars = str.toCharArray();
        System.out.println(chars);
        //Arrays：操作数组的工具类
        System.out.println(Arrays.toString(chars));
        //[j, a, v, a,  , A, n, d]
    }

    @Test
    public void test424() {
        String str = "java AndroidA";
        String newStr = str.replace('A', 'B');
        System.out.println(str);//java AndroidA
        System.out.println(newStr);//java BndroidB
    }

    @Test
    public void test66() {
        String str = "java android python";
        String[] array = str.split(" ");
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void test87() {
        // subtree: 子树
        // substring:子字符串
        // subtitle: 子标题
        String str = "java AndroidA";
        System.out.println(str.substring(5));//AndroidA

        //beginIndex – the beginning index, inclusive.
        //endIndex – the ending index, exclusive.
        System.out.println(str.substring(5, 8));//Andr
    }

    @Test
    public void test181() {
        String str = "    java AndroidA    ";
        String newStr = str.trim();
        System.out.println(str);//    java AndroidA
        System.out.println(newStr);//java AndroidA
    }

    @Test
    public void test55() {
        String str1 = "Java";
        String str2 = "PHP";
        String str3 = "Python";
        String str4 = "UI";
        String str = str1 + str2 + str3 + str4;
        System.out.println(str);

        StringBuffer buffer = new StringBuffer("C");
        //buffer.append(str1);
        //buffer.append(str2);
        //buffer.append(str3);
        //buffer.append(str4);
        //链式编程
        buffer.append(str1).append(str2).append(str3).append(str4);
        System.out.println(buffer);

        StringBuilder builder = new StringBuilder("C");
        builder.append(str1);
        builder.append(str2);
        builder.append(str3);
        builder.append(str4);
        System.out.println(builder);

        String s = builder.toString();

    }

    @Test
    public void test34() {
        System.out.println(Integer.MAX_VALUE);

        //自动装箱和拆箱
        Integer integer1 = Integer.valueOf(4);
        System.out.println(integer1);
        Integer integer2 = 4;//自动装箱
        System.out.println(integer2);
        int num1 = integer2.intValue();
        int num2 = integer2;//自动拆箱
        System.out.println(num1);
        System.out.println(num2);

        Integer integer = 3;
        int num = integer + 34;
        integer = integer + 34;
        integer = integer + integer1;

        boolean bool = true;
        String string = Boolean.toString(bool);//"true"

        double d = Double.parseDouble("3.14");
        System.out.println(d + 1);
    }

    @Test
    public void test11() {
        //String str = "---java Android---";
        //String str = "------";
        //String str = "";
        //String str = "---java Android";
        //String str = "java Android---";
        String str = null;
        String newStr = trim(str);
        System.out.println(newStr);
    }

    private String trim(String str) {
        //卫操作
        if (str == null || str.equals("")) {
            return "";
        }

        int startIndex = 0;
        int endIndex = str.length() - 1;
        while ((startIndex <= endIndex) && (str.charAt(startIndex) == '-')) {
            startIndex++;
        }
        while ((startIndex <= endIndex) && (str.charAt(endIndex) == '-')) {
            endIndex--;
        }
        return str.substring(startIndex, endIndex + 1);
    }

    @Test
    public void test45() {
        String str = "Hello Java";
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        String newStr = toLowerCase(str);
        System.out.println(newStr);
    }

    private String toLowerCase(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] = (char) (array[i] + 32);
            }
        }
        return new String(array);
    }
}
