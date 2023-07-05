package com.wenxuezheng.heap;

import java.util.Map;

/**
 * TODO
 *
 * @author  
 * @since 2019-03-01
 */

public class PrintJvmMemory {

    /**
     * -Xmx33m com.wenxuezheng.heap.PrintJvmMemory a b
     *
     * @param args
     */
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println("processor:" + Runtime.getRuntime().availableProcessors());
        System.out.println("total:" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
        System.out.println("Xms:" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println("Xmx:" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");

        for (Map.Entry<Thread, StackTraceElement[]> v : Thread.getAllStackTraces().entrySet()) {
            System.out.println("线程 : " + v.getKey().getName());
            for (StackTraceElement stackTraceElement : v.getValue()) {
                System.out.print("\t" + stackTraceElement + "\n");
            }
        }

    }

}
