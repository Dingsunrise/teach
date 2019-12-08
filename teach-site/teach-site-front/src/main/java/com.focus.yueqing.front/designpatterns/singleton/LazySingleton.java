package com.focus.yueqing.front.designpatterns.singleton;

/**
 * 懒汉模式 双重检查锁 加 volatile
 */
public class LazySingleton {

    /**
     * 设为 volatile 避免new LazySingleton(); 重排序导致 返回空
     */
    private volatile LazySingleton singleton = null;

    private LazySingleton(){
    }

    public LazySingleton getSingleton(){
        if(singleton==null){
            synchronized (this) {
                if (singleton == null) {
                    synchronized (this) {
                        singleton = new LazySingleton();
                    }
                }
            }
        }
        return singleton;
    }
}
