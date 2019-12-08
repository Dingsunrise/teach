package com.focus.yueqing.front.designpatterns.factory.simplefactory;

import com.focus.yueqing.front.designpatterns.factory.product.BmwCar;
import com.focus.yueqing.front.designpatterns.factory.product.Car;
import com.focus.yueqing.front.designpatterns.factory.product.LandRoverCar;
import com.focus.yueqing.front.designpatterns.factory.product.MercedesCar;

/**
 * 简单工厂
 */
public class SimpleCarFactory {

    public Car getCarApi(String type){
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
}
