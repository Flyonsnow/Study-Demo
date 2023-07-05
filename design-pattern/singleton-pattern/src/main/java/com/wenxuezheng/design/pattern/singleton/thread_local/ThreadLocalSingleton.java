package com.wenxuezheng.design.pattern.singleton.thread_local;


/**
 * TODO
 *
 * @author    
 * @date 2021/7/1 5:54 下午
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> tlFocusFinder =
            new ThreadLocal<ThreadLocalSingleton>() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    /**
     * Get the focus finder for this thread.
     */
    public static ThreadLocalSingleton getInstance() {
        return tlFocusFinder.get();
    }

    // enforce thread local access
    private ThreadLocalSingleton() {}
}
