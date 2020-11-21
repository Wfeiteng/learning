package com.train.learning.other;

import java.util.concurrent.Semaphore;

public class Test2 {
    // 编写一个多线程 分别有线程1输出1 线程2输出2 线程3输出3，要求输出结果是3 2 1
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(1);

    public void print1() throws InterruptedException {
        s1.acquire();
        System.out.println(1);
        s1.release();
    }
    public void print2() throws InterruptedException {
        s2.acquire();
        System.out.println(2);
        s1.release();
    }
    public void print3() throws InterruptedException {
        s3.acquire();
        System.out.println(3);
        s2.release();
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    test.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    test.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    test.print3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
