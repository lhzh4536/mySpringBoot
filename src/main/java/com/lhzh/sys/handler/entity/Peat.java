package com.lhzh.sys.handler.entity;

public class Peat extends Food {
    public  String  color = "白色";

    @Override
    public String getColor() {
        return color;
    }

    public Peat() {

    }

    @Override
    public void eat() {
        System.out.println("吃桃子" +color);
    }
}
