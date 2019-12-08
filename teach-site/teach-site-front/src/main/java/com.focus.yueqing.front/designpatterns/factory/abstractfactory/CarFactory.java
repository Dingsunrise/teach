package com.focus.yueqing.front.designpatterns.factory.abstractfactory;

import com.focus.yueqing.front.designpatterns.factory.product.*;

public class CarFactory extends Abstractfactory {
    @Override
    public Car getCar(String type) {
        if("bmw".equals(type)){
            return new BmwCar();
        }
        if("landRover".equals(type)){
            return new LandRoverCar();
        }
        if("mercedes".equals(type)){
            return new MercedesCar();
        }
        return null;
    }

    @Override
    public Color getColor(String type) {
        return null;
    }
}
