package com.wenxuezheng.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author hu.bo
 * 2022/8/25 21:01
 */
public class CompletableFutureTest {
    private static final ExecutorService EXECUTOR =
            new ThreadPoolExecutor(10,
                    20,
                    10L,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(1000),
                    new ThreadPoolExecutor.AbortPolicy()
            );

    public static void main(String[] args) throws InterruptedException {
        CompletableFutureTest completableFutureTest = new CompletableFutureTest();
        // completableFuture API
        //completableFutureTest.testComplete();
        //completableFutureTest.testHandle();
        //completableFutureTest.testApply();
        //completableFutureTest.testExceptionally();
        //completableFutureTest.testAccept();
        // 组合completableFuture
        //completableFutureTest.testCompose();
        //completableFutureTest.testCombine();
        //completableFutureTest.testAllOf();
        completableFutureTest.testAnyOf();



    }

    /**
     * 计算完成后续操作
     */
    private void testComplete() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1000);
        future.whenComplete((result, error) -> {
            System.out.printf("whenComplete, Thread name is : %s, The number is : %d \n",
                    Thread.currentThread().getName(),
                    result);
            error.printStackTrace();
        });
        future.whenCompleteAsync((result, error) -> {
            System.out.printf("whenCompleteAsync, Thread name is : %s, The number is : %d \n",
                    Thread.currentThread().getName(), result);
            error.printStackTrace();
        });
        future.whenCompleteAsync((result, error) -> {
            System.out.printf("whenCompleteAsync and executor,Thread name is : %s, The number is : %d \n",
                    Thread.currentThread().getName(), result);
            error.printStackTrace();
        }, EXECUTOR);
    }

    /**
     * 计算完成后续操作
     */
    private void testHandle() throws InterruptedException {
        CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> {
            List<String> list = new ArrayList<>();
            list.add("语文");
            list.add("数学");
            // 获取得到今天的所有课程
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return list;
        });
        // 使用handle()方法接收list数据和error异常
        CompletableFuture<Integer> future2 = future.handle((list, error) -> {
            // 如果报错，就打印出异常, 如果不报错error为null, 这里会产生NPE，会报出来
            if (error != null) {
                error.printStackTrace();
            }
            // 如果不报错，返回一个包含Integer的全新的CompletableFuture
            return list.size();
            // 注意这里的两个CompletableFuture包含的返回类型不同
        });
        // 可以有其他业务操作
        System.out.println("进行其他业务start");
        Thread.sleep(2000);
        System.out.println("进行其他业务end");
        System.out.println("异步运算结果:" + future2.join());
    }

    /**
     * 用来转换范型
     */
    private void testApply() {
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> 100)
                        .thenApply(result -> result.toString());
        System.out.println(future.join());
    }

    private void testExceptionally() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // 返回null
            return null;
        });
        CompletableFuture<String> exceptionally = future.thenApply(result -> {
            // 制造一个空指针异常NPE
            int i = result;
            return i;
        }).thenApply(result -> {
            // 这里不会执行，因为上面出现了异常
            String words = "现在是" + result + "点钟";
            return words;
        }).exceptionally(error -> {
            // 我们选择在这里打印出异常
            error.printStackTrace();
            // 并且当异常发生的时候，我们返回一个默认的文字
            return "出错啊~";
        });
        exceptionally.thenAccept(System.out::println);
    }

    private void testAccept() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1000);
        future.thenAccept((result) -> {
            System.out.println("消费到结果" + result);
        });
    }

    /**
     * 用来连接一个新的CompletableFuture
     */
    private void testCompose() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "rs");
        CompletableFuture<Integer> newFuture = future.thenCompose((s) ->
                CompletableFuture.supplyAsync(() -> {
                            System.out.println(s);
                            return 1;
                        }
                ));
    }

    private void testCombine() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "future1");
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture<Long> newFuture = future1.thenCombine(future2, (future1Result, future2Result) -> {
            System.out.println(future1Result);
            System.out.println(future2Result);
            return 1L;
        });
    }

    private void testAllOf() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "future1");
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture.allOf(future1, future2);
        System.out.println(future1.join() + future2.join());
    }

    private void testAnyOf() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "future1");
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        });
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future1, future2);
        System.out.println(anyOf.join());
    }
}
