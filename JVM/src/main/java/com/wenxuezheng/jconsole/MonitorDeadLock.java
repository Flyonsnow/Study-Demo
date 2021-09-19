package com.wenxuezheng.jconsole;

/**
 * TODO
 *
 * @author hubo
 * @since 2019-03-04
 */
public class MonitorDeadLock {

    static class SynAddRunnable implements Runnable {
        final Object obj1, obj2;

        public SynAddRunnable(Object obj1, Object obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            synchronized (obj1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println(obj1);
                    System.out.println(obj2);
                }
            }
        }
    }

    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        for (int i = 0; i < 100; i++) {


            new Thread(new SynAddRunnable(object1, object2)).start();
            new Thread(new SynAddRunnable(object2, object1)).start();
        }





    }
}

