package com.focus.yueqing.front.designpatterns.factory.abstractfactory;

import com.focus.yueqing.front.designpatterns.factory.product.*;

public class ColorFactory  extends Abstractfactory {
    @Override
    public Car getCar(String type) {
        return null;
    }

    @Override
    public Color getColor(String type) {
        if("red".equals(type)){
            return new Red();
        }
        if("blue".equals(type)){
            return new Blue();
        }
        return null;
    }
}