package com.learing.measurement.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 非中断锁
 */
public class UnInterruptLockDemo {

    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock reentrantLock = new ReentrantLock(true);// 得到可中断锁
        ReentrantLock reentrantLock = new ReentrantLock();

        Info info = new Info(reentrantLock);

        Thread writeThread = new Thread(new Write(info));
        Thread readThread = new Thread(new Read(info));

        writeThread.start();
        Thread.sleep(100); // 主线程睡眠100毫秒，让write线程先执行
        readThread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (; ; ) {
                    if (System.currentTimeMillis() - start > 5000) {
                        System.out.println("不等了，我都等了5秒了");
                        readThread.interrupt();
                        break;
                    }
                }
            }
        }).start();

    }


    static class Info {
        private Object lock;

        public Info(Object lock) {
            this.lock = lock;
        }

        public void write() {
            synchronized (lock) {
                long strat = System.currentTimeMillis();
                System.out.println("begin write.");
                for (; ; ) {
                    if (System.currentTimeMillis() - strat > Integer.MAX_VALUE)
                    {
                        break;
                    }

                }// 模拟长时间写
                System.out.println("write over....");
            }
        }

        public void read() {
            synchronized (lock) {
                System.out.println("read over...");
            }
        }
    }

    static class Write implements Runnable {

        private Info info;

        public Write(Info info) {
            this.info = info;
        }

        @Override
        public void run() {
            info.write();
        }
    }

    static class Read implements Runnable {
        private Info info;

        public Read(Info info) {
            this.info = info;
        }

        @Override
        public void run() {
            info.read();
        }

    }


}

