package com.lhzh.sys.handler.entity;

public class Food {
    public String color = "深红色" ;

    public String getColor() {
        return color;
    }

    public Food() {
    }

    public void eat(){
        System.out.println("吃食物" +color);
    }
}
