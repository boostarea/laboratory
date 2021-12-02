package org.example.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenrong
 * @version 1.0
 * @since 2021/12/2
 **/
public class ReentrantLockBasicSample {

    public static void main(String[] args) {

        ReentrantLock fairLock = new ReentrantLock(true);

        new Thread(() -> {
            try {
                System.out.println("线程A-开始执行");
                fairLock.lock();
                Thread.sleep(500_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // fairLock.unlock();
            }
            System.out.println("线程A-释放锁");
        }, "线程 A").start();

        new Thread(() -> {
            try {
                System.out.println("线程B-开始执行");
                fairLock.lock();
                Thread.sleep(300_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // fairLock.unlock();
            }
            System.out.println("线程B-释放锁");
        }, "线程 B").start();

        new Thread(() -> {
            try {
                System.out.println("线程C-开始执行");
                fairLock.lock();
                Thread.sleep(200_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // fairLock.unlock();
            }
            System.out.println("线程C-释放锁");
        }, "线程 C").start();
    }
}
