package org.example.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/12/2
 **/
public class LockSupportInterruptSample {

    public static void main(String[] args) {

        Object locker = new Object();

        Thread a = new Thread(() -> {
            LockSupport.park(locker);
            System.out.println("解锁成功, interrupted：" + Thread.interrupted());
            System.out.println(Thread.interrupted());
        }, "阻塞线程");

        a.start();

        a.interrupt();
    }
}
