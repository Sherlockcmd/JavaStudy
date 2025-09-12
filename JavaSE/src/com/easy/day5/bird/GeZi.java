package com.easy.day5.bird;

public class GeZi extends AbstractBird implements IFly{
    @Override
    public void egg() {
        System.out.println("GeZi.egg");
    }

    @Override
    public void fly() {
        System.out.println("GeZi.fly");
    }
}
