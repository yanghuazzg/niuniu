package com.niuniu.demo.jbase.lock;

/**
 * @author yanghua
 * @className SynchronizedObjectTestOne
 * @package com.niuniu.demo.jbase.lock
 * @describe
 * @date 2022/2/18
 */
public class SynchronizedClassTestThree implements Runnable {

    static SynchronizedClassTestThree instance1 = new SynchronizedClassTestThree();
    static SynchronizedClassTestThree instance2 = new SynchronizedClassTestThree();

    @Override
    public void run() {
        method();
    }

    /**
     * 所有线程需要的锁都是同一把
     */
    private static void method() {
        synchronized (SynchronizedClassTestThree.class) {
            System.out.println("线程" + Thread.currentThread().getName() + "开始");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "结束");
        }

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