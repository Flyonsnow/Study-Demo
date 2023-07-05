package com.wenxuezheng.oom;

/**
 * @author    
 * @date 2021/12/5 9:48 下午
 */
public class StackOverFlowError {

    public static void main(String[] args) {
        foo(1);
    }

    public static int foo(int i) {
        return foo(i + 1);
    }
}
