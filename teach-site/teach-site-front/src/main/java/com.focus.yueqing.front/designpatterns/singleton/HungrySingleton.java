package com.focus.yueqing.front.designpatterns.singleton;

/**
 * 饿汉模式
 */
public class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    public HungrySingleton getSingleton(){
        return hungrySingleton;
    }
}
