package com.focus.yueqing.front.designpatterns.singleton;

/**
 * 静态内部类 如果构造函数中有业务，并且出错 实例将无法被创建
 */
public class StaticSingleton {

    private StaticSingleton() {
    }

    public StaticSingleton getSingleton(){
        return InnerSingleton.singleton;
    }

    private static class InnerSingleton{
        private static StaticSingleton singleton = new StaticSingleton();
    }
}
