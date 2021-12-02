package org.example.JUC;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/8/11
 **/
public class DemonThread {

    public static void main(String[] args) {

        new Thread(() -> {
            // while(true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("alive");
                } catch (InterruptedException e) {
                }
            // }
        }).start();

        System.out.println("exit");
    }
}
