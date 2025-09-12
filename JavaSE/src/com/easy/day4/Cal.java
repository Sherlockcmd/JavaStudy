package com.easy.day4;

public class Cal {
    private int num1;
    private int num2;

    public Cal() {
    }

    public Cal(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    //单一职责原则：一个类、一个方法、一张表只表达一种类型的信息
    /*public void add() {
        int result = num1 + num2;
        System.out.println("add: " + result);
    }*/

    public int add() {
        return num1 + num2;
    }

    public int sub() {
        return num1 - num2;
    }


}
