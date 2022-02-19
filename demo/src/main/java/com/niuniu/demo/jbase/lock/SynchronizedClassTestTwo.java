package com.niuniu.demo.jbase.lock;

/**
 * @author yanghua
 * @className SynchronizedObjectTestOne
 * @package com.niuniu.demo.jbase.lock
 * @describe
 * @date 2022/2/18
 */
public class SynchronizedClassTestTwo implements Runnable {

    static SynchronizedClassTestTwo instance1 = new SynchronizedClassTestTwo();
    static SynchronizedClassTestTwo instance2 = new SynchronizedClassTestTwo();

    @Override
    public void run() {
        method();
    }

    /**
     *synchronized用在静态方法上，默认的锁就是当前所在的Class类，所以无论是哪个线程访问它，需要的锁都只有一把
     */
    private static synchronized void method(){
        System.out.println("线程" + Thread.currentThread().getName() + "开始");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() + "结束");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(instance1);
            Thread t2 = new Thread(instance2);
            t1.start();
            t2.start();
        }

    }


}