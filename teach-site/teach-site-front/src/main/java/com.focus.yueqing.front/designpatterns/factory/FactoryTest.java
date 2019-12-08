package com.focus.yueqing.front.designpatterns.factory;

import com.focus.yueqing.front.designpatterns.factory.abstractfactory.Abstractfactory;
import com.focus.yueqing.front.designpatterns.factory.abstractfactory.CarFactory;
import com.focus.yueqing.front.designpatterns.factory.product.Car;
import com.focus.yueqing.front.designpatterns.factory.simplefactory.SimpleCarFactory;
import com.focus.yueqing.front.designpatterns.factory.staticfactory.StaticFactory;

public class FactoryTest {
    public static void main(String[] args) {
        //简单工厂模式
        SimpleCarFactory simpleCarFactory = new SimpleCarFactory();
        Car car = simpleCarFactory.getCarApi("bmw");
        car.createCar();

        //静态工厂模式
        Car bmwCarApiCar = StaticFactory.getBmwCarApiCar();
        bmwCarApiCar.createCar();

        //抽象工厂模式
        Abstractfactory abstractfactory = new CarFactory();
        Car bmw = abstractfactory.getCar("bmw");
        bmw.createCar();
    }
}
