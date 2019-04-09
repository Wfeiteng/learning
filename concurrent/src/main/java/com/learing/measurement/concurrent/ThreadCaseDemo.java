package com.learing.measurement.concurrent;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition的作用是对锁进行更精确的控制。
 * Condition中的await()方法相当于Object的wait()方法，
 * Condition中的signal()方法相当于Object的notify()方法，
 * Condition中的signalAll()相当于Object的notifyAll()方法。
 * 不同的是:
 * Object中的wait(),notify(),notifyAll()方法是和"同步锁"(synchronized关键字)捆绑使用的;
 * 而Condition是需要与"互斥锁"/"共享锁"捆绑使用.
 *
 * @author zhengtengwang
 */
public class ThreadCaseDemo {

    static class Info {    // 定义信息类

        /**
         * 定义name属性，为了与下面set的name属性区别开
         */
        private String name = "name";
        /**
         * 定义content属性，为了与下面set的content属性区别开
         */
        private String content = "content";
        /**
         * 设置标志位,初始时先生产
         */
        private boolean flag = true;
        private Lock lock = new ReentrantLock();
        /**
         * 产生一个Condition对象
         */
        private Condition condition = lock.newCondition();

        public void set(String name, String content) {
            lock.lock();
            try {
                while (!flag) {
                    condition.await();
                }
                this.setName(name);
                // 设置名称
                Thread.sleep(300);
                this.setContent(content);
                // 设置内容
                flag = false;
                // 改变标志位，表示可以取走
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void get() {
            lock.lock();
            try {
                while (flag) {
                    condition.await();
                }
                Thread.sleep(300);
                System.out.println(this.getName() +
                        " --> " + this.getContent());
                flag = true;
                // 改变标志位，表示可以生产
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 测试awaitUninterruptibly方法。
         */
        public void awaitUninterruptiblyTest() {
            lock.lock();
            condition.awaitUninterruptibly();
            lock.unlock();
            System.out.println("awaitUninterruptibly()--finish");
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getName() {
            return this.name;
        }

        public String getContent() {
            return this.content;
        }
    }


    /**
     * 通过Runnable实现多线程
     */
    static class Producer implements Runnable {

        private Info info = null;
        // 保存Info引用

        public Producer(Info info) {
            this.info = info;
        }

        @Override
        public void run() {
            boolean flag = true;
            // 定义标记位
            for (int i = 0; i < 10; i++) {
                if (flag) {
                    // 设置名称
                    this.info.set("姓名--1", "内容--1");
                    flag = false;
                } else {
                    // 设置名称
                    this.info.set("姓名--2", "内容--2");
                    flag = true;
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private Info info = null;

        public Consumer(Info info) {
            this.info = info;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                this.info.get();
            }
        }
    }

    public static void main(String args[]) {
        // 实例化Info对象
        Info info = new Info();
        // 生产者
        Producer pro = new Producer(info);
        // 消费者
        Consumer con = new Consumer(info);
        new Thread(pro).start();
        //启动了生产者线程后，再启动消费者线程
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(con).start();
    }

    @Test
    public void awaitUninterruptiblyTest() throws InterruptedException {
        Info info = new Info();
        Thread thread = new Thread() {
            @Override
            public void run() {
                info.awaitUninterruptiblyTest();
                System.out.println("run finish");
            }
        };

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("main-after");
        System.out.println(thread.isInterrupted());

while(true){

}
    }

}

