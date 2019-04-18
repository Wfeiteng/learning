package com.learing.measurement.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public void a(CountDownLatch latch) {
        System.out.println(Thread.currentThread().getName() + " 执行。。。");

        latch.countDown(); // 老师点一个走一个，人数就少一个
    }

    public static void main(String[] args) {
        // 计数器的初始值为10，这个值会随着countDown方法的执行而减少
       CountDownLatch latch = new CountDownLatch(10);

        CountDownLatchTest demo = new CountDownLatchTest();

        /*
            执行的线程数小于 countdownlatch 的初始化值，就不会继续往下执行呗
            执行的线程数大于 countdownlatch 的初始值呢，能继续往下执行，其他的线程应该也会执行。
                不过其他的线程既然可以执行，那么count的值呢？？？look source 看看能不能找到答案。
                源码中，当count的值为0时就直接返回了，不会在执行减法了。
         */
        for (int i = 0; i < 11; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.a(latch);
                }
            }).start();

        }

        try {
            System.out.println("begin await....");
            latch.await(); // 等待countdownlatch 的count变为0 才会执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over await, main thread keep running....");

    }

}
