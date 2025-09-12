package com.easy.day5.bird;

public class OOPDemo {

    public static void main(String[] args) {
        DaYan daYan = new DaYan();
        daYan.egg();
        daYan.fly();
        daYan.print();

        AbstractBird bird = new DaYan();
        bird.egg();
        //bird.fly();
        //bird.print();

        IFly fly = new DaYan();
        fly.fly();
        //fly.egg();
        //fly.print();
        fly = new GeZi();
        fly.fly();
    }
}
