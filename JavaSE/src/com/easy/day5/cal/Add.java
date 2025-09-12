package com.easy.day5.cal;

public class Add extends Cal{

    public Add() {
        super();
    }

    public Add(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int getResult() {
        return num1 + num2;
    }


}
