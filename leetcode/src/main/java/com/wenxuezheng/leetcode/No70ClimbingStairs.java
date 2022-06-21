package com.wenxuezheng.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * #70
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class No70ClimbingStairs {

    public static void main(String[] args) {
        int[] testNums = {0, 1, 2, 3, 4, 5, 45};

        for (int testNum : testNums) {
            int result = climbStairs20220620Recursion(testNum);
            result = climbStairs20220621(testNum);
            result = climbStairs20220621Optimization(testNum);
            System.out.println(result);
        }
    }

    /**
     * 第一遍做的时候没有思路， 查看题解
     * https://leetcode.com/problems/climbing-stairs/discuss/963994/Java-from-Recursion-to-DP
     * <p>
     * 做法思路就是从顶端向回走，只能有两种方式，1步或者2步，所以结果就是f(n) = f(n-1) + f(n-2)
     * 这里遇到一个问题，开始看题解想到，为什么不是 f(n) = (f(n-1) + 1) + (f(n-2) +1), 因为题目需要的是到达顶端的方法的数量，不是步数
     * 因此，f(n-1)只有一种方式到顶多， f(n-2)虽然有两种走法， 1或2，但是走1步后就与f(n-1)相同了，所以也只有一种走法就是2部到顶
     * 因此到顶就是f(n-1)的方法数 加 f(n-2)的方法数了，
     * 依次向下递归或遍历即可
     * Complexity : Time: O(2^n) ; Space: O(n)
     * <p>
     * tips:虽然逻辑上此方法可以实现,但是因为时间复杂度过高，在leetcode上无法提交通过
     *
     * @param n
     * @return
     */
    public static int climbStairs20220620Recursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs20220620Recursion(n - 1) + climbStairs20220620Recursion(n - 2);
    }

    /**
     * Time: O(n) ; Space: O(n)
     *
     * @param n
     * @return
     */
    public static int climbStairs20220620RecursionWithMemorization(int n) {
        Map<Integer, Integer> mem = new HashMap<>(n);
        mem.put(0, 0);
        mem.put(1, 1);
        mem.put(2, 2);
        return climbStairs20220620RecursionWithMemorizationHandle(n, mem);

    }

    private static int climbStairs20220620RecursionWithMemorizationHandle(int n, Map<Integer, Integer> mem) {
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        mem.put(n,
                climbStairs20220620RecursionWithMemorizationHandle(n - 1, mem) + climbStairs20220620RecursionWithMemorizationHandle(n - 2, mem));
        return mem.get(n);
    }

    /**
     * Complexity : Time: O(n) ; Space: O(n)
     *
     * @param n
     * @return
     */
    public static int climbStairs20220621(int n) {
        // 当n<=1时， 数组长度n+1为2, nums[2]会报ArrayIndexOutOfBoundsException
        if (n <= 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;

        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    /**
     * Complexity : Time: O(n) ; Space: O(1)
     *
     * @param n
     * @return
     */
    public static int climbStairs20220621Optimization(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 2;

        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return prev2;
    }
}
