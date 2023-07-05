package com.wenxuezheng.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 *
 * @author  
 * @since 2019-03-04
 */
public class MonitorMemory {

    static class OOmObject {
        public byte[] placeHolder = new byte[64 * 2014];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOmObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(500);
            list.add(new OOmObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(10000);
    }
}
