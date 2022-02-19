package com.niuniu.demo.jbase.lock;

/**
 * @author yanghua
 * @className SynchronizedDemoTest
 * @package com.niuniu.demo.jbase.lock
 * @describe
 * @date 2022/2/18
 */
public class SynchronizedDemoTest {

    public static void main(String[] args) {
        method1();
    }

    static Object object = new Object();

    public static void method1() {
        synchronized (object) {

        }
    }

    private static void method2() {
    }
}
