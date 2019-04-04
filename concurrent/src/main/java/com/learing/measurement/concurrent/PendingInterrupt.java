package com.learing.measurement.concurrent;

public class PendingInterrupt {

    public static void main(String[] args) {
        // 如果类的参数大于0，就中断当前线程
        if (args.length > 0){
            Thread.currentThread().interrupt();
        }else {
            System.out.println("main thread wasn't interrupted");
        }

        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("main thread was interrupted");
        }
        System.out.println("cost time: "+(System.currentTimeMillis() - begin));
    }
}
