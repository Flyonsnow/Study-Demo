package com.wenxuezheng.leetcode;


/**
 * #11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * <p>
 * 题解
 * https://leetcode.cn/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
 */
public class No11ContainerWithMostWater {


    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = containerWithMostWater20220622(height);

        System.out.println("max area :" + maxArea);


    }

    /**
     * 双指针解法
     *
     * @param height
     * @return
     */
    public static int containerWithMostWater20220622(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    private static int containerWithMostWater20220622Repeat(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j-i);
            res = Math.max(res, area);
            if(height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return res;
    }


}
