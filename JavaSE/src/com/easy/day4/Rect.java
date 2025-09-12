package com.easy.day4;

public class Rect {
    private int width;
    private int height;

    public Rect() {
        //width = 1;
        //height = 1;
        this(1, 1);//new Rect(1, 1);
    }

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rect(int width) {
        this.width = width;
        this.height = width;
    }

    public int zhouChang() {
        return (width + height) * 2;
    }

    public int mianJi() {
        return width * height;
    }
}
