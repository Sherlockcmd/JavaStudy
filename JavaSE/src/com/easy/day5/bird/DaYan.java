package com.easy.day5.bird;

public class DaYan extends AbstractBird implements IFly{
    @Override
    public void egg() {
        System.out.println("DanYan.egg");
    }

    @Override
    public void fly() {
        System.out.println("DanYan.fly");
    }

    public void print() {
        System.out.println("DaYan.print");
    }
}
