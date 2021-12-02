package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/4/29
 **/
public class GcTest {


    public static final int _1M = 1024*1024;
    public static final int _1K = 1024;
    // private static Map<Integer, byte[]> map = new HashMap<>();


    public static void main(String[] args) throws InterruptedException {

        // while (true) {
            Map<Integer, byte[]> map = new HashMap<>();
            // 申请2000M空间
            for (int i=0; i< 800; i++) {
                byte[] b = new byte[_1M];
                // 保持引用，防止GC回收
                map.put(i, b);
            }


            // 不断在新生代分配内存，以触发新生代GC
            for (int k = 0; k < 1000; k++) {
                for (int i = 0; i < 100; i++) {
                    byte[] g = new byte[_1M];
                    if (100 == k) {
                        System.out.println("fgc1");
                        // 为老年代GC，创建条件
                        map = null;
                    }
                }
                // TimeUnit.SECONDS.sleep(3);
            }
            TimeUnit.SECONDS.sleep(60 * 5);
        // }
    }
}
