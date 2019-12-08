package com.focus.yueqing.front.designpatterns.factory.abstractfactory;

import com.focus.yueqing.front.designpatterns.factory.product.Car;
import com.focus.yueqing.front.designpatterns.factory.product.Color;

public abstract class Abstractfactory {
    public abstract Car getCar(String type);

    public abstract Color getColor(String type);
}
