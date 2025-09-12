package com.easy.day6;

import org.junit.Test;

import java.math.MathContext;
import java.util.Arrays;
import java.util.Map;

public class StaticDemo {

    @Test
    public void test1() {
        Student student = new Student();
        student.show();
        //Static member 'com. easy. day6.Student. print()' accessed via instance reference
        student.print();
        Student.print();

        student.id = 2;
        student.country = "国";
        Student.country = "国";

        int max = Math.max(3, 5);
        System.out.println(max);
        //'Math()' has private access in 'java. lang. Math'
        //Math math = new Math();

        //Arrays数组操作的工具类
        int[] array = {34, 45, 7, 89};
        System.out.println(array);//[I@d7b1517
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        //先Arrays.sort排好序，再进行二分查找
        int index = Arrays.binarySearch(array, 77);
        System.out.println(index);

        int sum = ArraysUtil.sum(array);
        System.out.println(sum);
    }
}
