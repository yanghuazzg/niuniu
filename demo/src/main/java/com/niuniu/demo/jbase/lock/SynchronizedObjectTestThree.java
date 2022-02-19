package com.niuniu.demo.jbase.lock;

/**
 * @author yanghua
 * @className SynchronizedObjectTestOne
 * @package com.niuniu.demo.jbase.lock
 * @describe
 * @date 2022/2/18
 */
public class SynchronizedObjectTestThree implements Runnable {

    static SynchronizedObjectTestThree instance = new SynchronizedObjectTestThree();


    @Override
    public void run() {
      method();
    }

    /**
     *方法锁形式:synchronized修改普通方法，锁对象默认为this
    */
    private synchronized void method(){
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
            Thread t1 = new Thread(instance);
            Thread t2 = new Thread(instance);
            t1.start();
            t2.start();
        }

    }
}