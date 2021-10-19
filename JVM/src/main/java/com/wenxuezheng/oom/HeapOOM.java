package com.wenxuezheng.oom;


import java.util.ArrayList;
import java.util.List;

/**
 * jvm heap oom
 *
 * @author hubo
 * @since 2019-02-27
 */
public class HeapOOM {

    static class OOMObject {}


    /**
     * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }

    }

}
