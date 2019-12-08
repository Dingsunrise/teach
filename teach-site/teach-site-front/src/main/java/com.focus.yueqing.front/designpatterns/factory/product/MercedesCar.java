package com.focus.yueqing.front.designpatterns.factory.product;

public class MercedesCar implements Car {
    @Override
    public void createCar() {
        System.out.println("create a MercedesCar");
    }
}
