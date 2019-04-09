package com.learing.measurement.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptLockDemo {

    public static void main(String[] args) throws InterruptedException {
        // 得到可中断锁
        ReentrantLock reentrantLock = new ReentrantLock(true);

        Info2 info = new Info2(reentrantLock);

        Thread writeThread = new Thread(new Write2(info));
        Thread readThread = new Thread(new Read2(info));

        writeThread.start();
        // 主线程睡眠100毫秒，让write线程先执行
        Thread.sleep(100);
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

}

class Info2 {
    private ReentrantLock lock;

    public Info2(ReentrantLock lock) {
        this.lock = lock;
    }

    public void write() {
        lock.lock();
        try {
            long strat = System.currentTimeMillis();
            System.out.println("begin write.");
            for (; ; ) {
                if (System.currentTimeMillis() - strat > Integer.MAX_VALUE){
                    break;
                }

            }// 模拟长时间写
            System.out.println("write over....");
        } finally {
            lock.unlock(); // ReentrantLock的加锁和释放锁
        }
    }

    public void read() throws InterruptedException {
        lock.lockInterruptibly(); // 将查中断锁
        try {
            System.out.println("begin read");
        } finally {
            lock.unlock();
        }
    }
}

class Write2 implements Runnable {

    private Info2 info;

    public Write2(Info2 info) {
        this.info = info;
    }

    @Override
    public void run() {
        info.write();
    }
}

class Read2 implements Runnable {
    private Info2 info;

    public Read2(Info2 info) {
        this.info = info;
    }

    @Override
    public void run() {
        try {
            info.read();
        } catch (InterruptedException e) {
            System.out.println("读 被中断了");
        }
        System.out.println("读 结束了");
    }
}
