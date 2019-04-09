package com.learing.measurement.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemo {
    public static void main(String[] args){
        // 可重入锁
      Lock lock = new  ReentrantLock();
      // 读写锁
      ReadWriteLock writeLock = new ReentrantReadWriteLock();
        writeLock.readLock();
        writeLock.writeLock();
    }
}
