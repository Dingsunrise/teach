package com.focus.yueqing.front.designpatterns.factory.product;

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("blue color");
    }
}
