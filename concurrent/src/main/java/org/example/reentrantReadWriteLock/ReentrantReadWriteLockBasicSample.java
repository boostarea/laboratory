package org.example.reentrantReadWriteLock;

import javax.sound.midi.Soundbank;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/12/2
 **/
public class ReentrantReadWriteLockBasicSample {

    public static void main(String[] args) throws InterruptedException {

        RwTreeMap rwTreeMap = new RwTreeMap();

        rwTreeMap.put("1", "1");
        rwTreeMap.put("2", "2");
        rwTreeMap.put("3", "3");

        new Thread(() -> {
            try {
                System.out.println(rwTreeMap.allKeys());
                System.out.println(rwTreeMap.allKeys());
                System.out.println(rwTreeMap.allKeys());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(rwTreeMap.allKeys());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(rwTreeMap.allKeys());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(rwTreeMap.allKeys());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(rwTreeMap.allKeys());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public static class RwTreeMap {
        private final Map<String ,String> m = new TreeMap<>();
        private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        private final Lock r = rwl.readLock();
        private final Lock w = rwl.writeLock();

        public String get(String key) {
            r.lock();
            try {
                return m.get(key);
            } finally {
                r.unlock();
            }
        }

        public Object[] allKeys() throws InterruptedException {
            w.lock();
            try {
                return m.keySet().toArray();
            } finally {
                // r.unlock();
            }
        }

        public String put(String key, String value) {
            w.lock();
            try {
                return m.put(key, value);
            } finally {
                w.unlock();
            }
        }

        public void clear() {
            w.lock();
            try {
                m.clear();
            } finally {
                w.unlock();
            }
        }

    }
}
