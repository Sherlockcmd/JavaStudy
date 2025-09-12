package com.easy.day2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;


public class ArrayDemo {
    @Test
    public void test1() {
        int score1 = 23;
        int score2 = 53;
        int score3 = 73;
        int score4 = 83;
        int[] array = new int[4];
        array[0] = 23;
        array[1] = 3;
        array[2] = 4;
        array[3] = 24;
        //for (int i = 0; i <= array.length - 1; i++) {
        for (int i = 0; i < array.length; i++) {
            //System.out.println(i);
            System.out.println(array[i]);
        }
        System.out.println("-----------");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    @Test
    public void test45() {
        int[] array = new int[4];
        array[0] = 33;
        array[1] = 2;
        array[2] = 45;
        array[3] = 19;
        for (int i = 0; i <= array.length; i++) {
            //java.lang.ArrayIndexOutOfBoundsException: 4
            System.out.println(array[i]);
        }
    }

    @Test
    public void test47() {
        int[] array = new int[4];
        array[0] = 33;
        array[1] = 2;
        array[2] = 45;
        array[3] = 19;
        int sum = 0;
        //fori   array.fori
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }

    //数组最重要操作就是遍历。
   //只要能遍历所有元素：求最大值、最小值、排序。
    @Test
    public void test23(){
        int[] array = {23, 45, 67, 2, 12};
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("max: " + max);
    }

    @Test
    public void test24(){
        int[] array = {23, 45, 67, 2, 12};
        int max = getMax(array);
        System.out.println("max: " + max);
    }

    /**
     * 返回数组最大值
     * @param array 传递过来的数组
     * @return 数组最大值
     */
    //方法签名
    public int getMax(int[] array) {//方法体
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    @Test
    public void test22() {
        int[] array = {40, 17, 21, 1}; // 1, 17,21,40
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private void sort(int[] array) {
        for (int i = 1; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Test
    public void test34() {
        int[] source = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        System.arraycopy(source, 0, dest, 0, source.length);
        /*for (int i = 0; i < dest.length; i++) {
            System.out.println(dest[i]);
        }*/
        //增强的for循环
        for (int num : dest) {
            System.out.println(num);
        }
    }

    @Test
    public void test56() {
        int[] source = {1, 2, 3, 4, 5};
        //[from,to)
        int[] copiedArray = Arrays.copyOfRange(source, 1, 4); // 复制整个数组

        for (int num : copiedArray) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void test89() {
        int[][] array = new int[3][];
        array[0] = new int[2];
        array[1] = new int[2];
        array[2] = new int[3];
        array[0][0] = 23;
        array[0][1] = 12;
        array[1][0] = 22;
        array[1][1] = 22;
        array[2][0] = 21;
        array[2][1] = 22;
        array[2][2] = 23;
        //System.out.println(array.length);//3
        for (int i = 0; i < array.length; i++) {
            //array[0]
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }

//    1、int[] scores={0,0,1,2,3,5,4,5,2,8,7,6,9,5,4,8,3,1,0,2,4,8,7,9,5,2,1,2,3,9};
//    求出上面数组中0-9分别出现的次数
    @Test
    public void test55() {
        int[] scores={0,0,1,2,3,5,4,5,2,8,7,6,9,5,4,8,3,1,0,2,4,8,7,9,5,2,1,2,3,9};
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == 0) {
                count0++;
            } else if (scores[i] == 1) {
                count1++;
            } else if (scores[i] == 2) {
                count2++;
            } else if (scores[i] == 3) {
                count3++;
            }
        }
        System.out.println("0出现次数：" + count0);
        System.out.println("1出现次数：" + count1);
        System.out.println("2出现次数：" + count2);
        System.out.println("3出现次数：" + count3);
    }

    @Test
    public void test155() {
        int[] scores={0,0,1,2,3,5,4,5,2,8,7,6,9,5,4,8,3,1,0,2,4,8,7,9,5,2,1,2,3,9};
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < scores.length; i++) {
            switch (scores[i]) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
            }
        }
        System.out.println("0出现次数：" + count0);
        System.out.println("1出现次数：" + count1);
        System.out.println("2出现次数：" + count2);
        System.out.println("3出现次数：" + count3);
    }

    @Test
    public void test255() {
        int[] scores={0,0,1,2,3,5,4,5,2,8,7,6,9,5,4,8,3,1,0,2,4,8,7,9,5,2,1,2,3,9};
        int[] counts = new int[10];
        for (int i = 0; i < scores.length; i++) {
            counts[scores[i]]++;
            /*switch (scores[i]) {
                case 0:
                    counts[0]++;
                    break;
                case 1:
                    counts[1]++;
                    break;
                case 2:
                    counts[2]++;
                    break;
                case 3:
                    counts[3]++;
                    break;
            }*/
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "出现次数" + counts[i]);
        }
    }

    @Test
    public void test345() {
        //String str = "abcba";
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = scanner.next();
        char[] array = str.toCharArray();
        //初始认为是回文
        //boolean flag = true;
        boolean isHuiwen = true;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - i -1]) {
                isHuiwen = false;
                break;
            }
        }
        //初始认为是回文，遍历完了，没有找到任何一个反例，这个字符串就是回文
        if (isHuiwen) {
            System.out.println("是回文");
        } else {
            System.out.println("不是回文");
        }
    }

    //输入一行字符串，分别统计出其中英文字母、空格、数字和其它字符的个数。
    @Test
    public void test234() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = scanner.nextLine();
        System.out.println(str);
        char[] array = str.toCharArray();
        int letterCount = 0;
        int spaceCount = 0;
        int digitCount = 0;
        int otherCount = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >= 'A' && array[i] <= 'Z') || (array[i] >= 'a' && array[i] <= 'z')) {
                letterCount++;
            } else if (array[i] == ' ') {// ""
                spaceCount++;
            } else if (array[i] >= '0' && array[i] <= '9') {
                digitCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println("字母出现的次数： " + letterCount);
        System.out.println("空格出现的次数： " + spaceCount);
        System.out.println("数字出现的次数： " + digitCount);
        System.out.println("其他出现的次数： " + otherCount);
    }
}
