package org.example;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/4/27
 **/
public class VolatileTest {

    // private boolean flag = true;
    private volatile boolean flag = true;

    public void refresh() {
        flag = false;
        System.out.println("flag -> false");
    }

    public void load() {
        int i =0;
        while (flag) {
            ++i;
        }
        System.out.println("跳出循环");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest test = new VolatileTest();

        new Thread(test::load, "A").start();

        Thread.sleep(2000);
        new Thread(test::refresh, "B").start();
    }

}
