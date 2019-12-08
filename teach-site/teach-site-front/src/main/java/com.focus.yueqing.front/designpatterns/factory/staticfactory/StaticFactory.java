package com.focus.yueqing.front.designpatterns.factory.staticfactory;

import com.focus.yueqing.front.designpatterns.factory.product.BmwCar;
import com.focus.yueqing.front.designpatterns.factory.product.Car;
import com.focus.yueqing.front.designpatterns.factory.product.LandRoverCar;
import com.focus.yueqing.front.designpatterns.factory.product.MercedesCar;

public class StaticFactory {

    public static Car getBmwCarApiCar(){
        return new BmwCar();
    }

    public static Car getLandRoverCar(){
        return new LandRoverCar();
    }

    public static Car getMercedesCarCar(){
        return new MercedesCar();
    }
}
