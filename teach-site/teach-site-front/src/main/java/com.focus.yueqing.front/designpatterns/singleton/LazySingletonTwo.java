package com.focus.yueqing.front.designpatterns.singleton;

public class LazySingletonTwo {

    private volatile LazySingletonTwo singleton = null;

    private LazySingletonTwo(){
    }

    public LazySingletonTwo getSingleton(){
        if(singleton==null){
            initSingleton();
        }
        return singleton;
    }

    /**
     * 方法层面加锁 防止恶意竞争 且只在初始化时加载一次 所以不影响性能
     */
    private synchronized void initSingleton(){
        if (singleton == null) {
            singleton = new LazySingletonTwo();
        }
    }
}
