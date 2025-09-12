package com.easy.day5.cal;

public abstract class Cal {
    protected int num1;
    protected int num2;

    public Cal() {
    }

    public Cal(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    //方法签名
//    public int getResult() {// 方法体
//        return 0;
//    }

    //Alt+Enter
    public abstract int getResult();

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
}
