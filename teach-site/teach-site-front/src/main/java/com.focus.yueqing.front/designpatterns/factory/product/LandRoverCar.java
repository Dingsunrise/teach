package com.focus.yueqing.front.designpatterns.factory.product;

public class LandRoverCar implements Car {
    @Override
    public void createCar() {
        System.out.println("create a LandRoverCar");
    }
}
