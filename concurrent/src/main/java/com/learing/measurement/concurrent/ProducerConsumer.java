package com.learing.measurement.concurrent;

import lombok.Data;

/**
 * 生产者-消费者模型
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Info info = new Info();
        Thread producer = new Thread(new Producer(info));
        Thread consumer = new Thread(new Consumer(info));
        producer.start();
        consumer.start();
    }
}


/**
 * 消费者
 */
class Consumer implements Runnable {
    private Info info;

    public Consumer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            info.consumer();
        }
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {

    private Info info;

    public Producer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            info.producer("product"+i, i);
        }
    }
}

@Data
class Info {
    private String name;
    private int age;
    private boolean isProducer = true;

    public synchronized void consumer() {
        while (isProducer) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("consumer wait interrupted");
            }
        }
        System.out.println("consumer get " + this.name + ",age is " + this.age);
        isProducer = true;
        notify();

    }

    public synchronized void producer(String name, int age) {
        while (!isProducer) { //不是生产者，需要等待
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("producer wait interrupted");
            }
        }

        setAge(age);
        setName(name);
        System.out.println("productor create one Info");

        isProducer = false;
        notify(); // 唤醒等待的线程
    }
}