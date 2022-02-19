package com.niuniu.demo.jbase.lock;

/**
 * @author yanghua
 * @className SynchronizedObjectTestOne
 * @package com.niuniu.demo.jbase.lock
 * @describe
 * @date 2022/2/18
 */
public class SynchronizedObjectTestTwo implements Runnable {

    static SynchronizedObjectTestTwo instance = new SynchronizedObjectTestTwo();

    // 创建2把锁
    Object block1 = new Object();
    Object block2 = new Object();


    @Override
    public void run() {
       synchronized (block1) {
           System.out.println("block1锁 - 线程" + Thread.currentThread().getName() + "开始");
           try {
               Thread.sleep(3000L);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("block1锁 - 线程" + Thread.currentThread().getName() + "结束");
       }
       synchronized (block2) {
           System.out.println("block2锁 - 线程" + Thread.currentThread().getName() + "开始");
           try {
               Thread.sleep(3000L);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("block2锁 - 线程" + Thread.currentThread().getName() + "结束");
       }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

    }
}