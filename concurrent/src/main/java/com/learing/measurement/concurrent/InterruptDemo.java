package com.learing.measurement.concurrent;

/**
 * 线程终端
 */
public class InterruptDemo implements Runnable{
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("begin run ....");
 /*       long time = System.currentTimeMillis();
        while (time>1000&&!Thread.currentThread().isInterrupted()){
            System.out.println("test");
            Thread.currentThread().interrupt();
        }*/

        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("sleeping is interrupted..");
            System.out.println("child interrupt state:"+Thread.currentThread().isInterrupted());
        }
        System.out.println("thread over normal");
    }

    public static void main(String[] args){
        InterruptDemo demo = new InterruptDemo();
        Thread thread = new Thread(demo);
        thread.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted....");
        }
        System.out.println("interrupt thread..");
      //  System.out.println("main-child before interrupt state:"+thread.isInterrupted());
        thread.interrupt();
        System.out.println("main-child interrupt state:"+thread.isInterrupted());
        System.out.println("main thread over....");

    }


}

class NotResponseInterrupt implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while(true){
            System.out.println("NotResponseInterrupt");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NotResponseInterrupt interrupt = new NotResponseInterrupt();
        Thread thread = new Thread(interrupt);
        thread.start();
        Thread.sleep(2);
        thread.interrupt();
        System.out.println("main run over");
    }
}
