package com.niuniu.demo.jbase.lock;

/**
 * @author yanghua
 * @className SynchronizedObjectTestOne
 * @package com.niuniu.demo.jbase.lock
 * @describe
 * @date 2022/2/18
 */
public class SynchronizedObjectTestOne implements Runnable {

    /*
      一把锁只能同时被一个线程获取，没有获得锁的线程只能等待；
      每个实例都对应有自己的一把锁(this) 不同实例之间互不影响；例外：锁对象是*.class以及synchronized修改的是static方法的时候，所有对象公用一把锁
      synchronized修饰的方法，无论方法正常执行完毕还是抛出异常，都会释放锁
    */

    static SynchronizedObjectTestOne instance = new SynchronizedObjectTestOne();

    @Override
    public void run() {
        // 同步代码块形式——锁为this,两个线程使用的锁是一样的,线程1必须要等到线程0释放了该锁后，才能执行
        synchronized (this) {
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
            Thread t1 = new Thread(instance);
            Thread t2 = new Thread(instance);
            t1.start();
            t2.start();
        }

    }
}