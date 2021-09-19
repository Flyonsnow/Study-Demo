package com.wenxuezheng.jconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO
 *
 * @author hubo
 * @since 2019-03-04
 */
public class MonitorThread {

    /**
     * 死循环
     */
    public static void createBusyThread() {
        Thread thread = new Thread(() -> {
            while (true) ;
        }, "testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        createBusyThread();

        br.readLine();

        Object object = new Object();

        createLockThread(object);
    }

}
