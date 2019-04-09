package com.learing.measurement.concurrent;

public class SingletonModel {
    public static void main(String[] args) {
        /**
         * 多线程环境下，懒汉模式会有安全问题，获取的实例对象不是同一个
         * 这就需要使用到 双重检查加锁 （DCL）
         */
//        for (int i = 0; i < 12; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(1002);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(LazyModel.getInstance());
//                }
//            }).start();
//        }

        for (int i = 0; i < 12; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1002);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(LazyModel2.getInstance());
                }
            }).start();
        }
    }

}

/**
 * 饿汉模式
 */
class HungryModel {
    private HungryModel hungryModel = new HungryModel();

    private HungryModel() {
    }

    public HungryModel getInstance() {
        return hungryModel;
    }
}

/**
 * 懒汉模式
 */
class LazyModel {
    private static LazyModel instance;

    private LazyModel() {
    }

    public static LazyModel getInstance() {
        if (instance == null) {
            instance = new LazyModel();
        }
        return instance;
    }
}

/**
 * 懒汉模式 双重检查加锁
 */
class LazyModel2 {
    private static LazyModel2 instance;

    private LazyModel2() {
    }

    /**
     * DCL 传统的DCL，因为第一个instance == null 没有加锁，所以导致线程B 可能会得到instance
     * 的空或者非空，属于线程不安全。  第二个 instance == null 因为在同步代码块中，
     * 所以每次得到的instance都是最新的。
     * 用happen-before 来分析，同一个锁中的unlock操作必定happen-before 在lock的操作
     * <p>
     * 因为第一个instance == null 是非同步的，所以这是DCL的BUG
     * 对于BUG的解决，1、使用静态内部类 2、将instance变量使用volatile修饰
     *
     * @return
     */
    public static LazyModel2 getInstance() {
        if (instance == null) {
            synchronized (LazyModel.class) {
                if (instance == null) {
                    instance = new LazyModel2();
                }
            }
        }
        return instance;
    }
}

/**
 * 懒汉模式BUG  的 解决方法之 使用静态内部类
 */
class LazyModelClass3 {

    private LazyModelClass3() {
    }

    static class StaticLazyModelClass {
        private static final LazyModelClass3 lazyModelClass3 = new LazyModelClass3();
    }

    public static LazyModelClass3 getInstance() {
        return StaticLazyModelClass.lazyModelClass3;
    }
}
