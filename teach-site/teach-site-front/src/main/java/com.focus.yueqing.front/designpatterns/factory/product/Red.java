package com.focus.yueqing.front.designpatterns.factory.product;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("red color");
    }
}