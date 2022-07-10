package com.wenxuezheng.leetcode.array.traverse;


import java.util.ArrayList;
import java.util.List;

/**
 * 最大值只有两种可能，三个最大值的乘积 或   最大值 * 两个最小值
 * 方法1： 先排序，然后取值， 取决于排序的Time
 * 方法2： 遍历比较最大3个和最小2个， Time: O(n)
 */
public class No628MaximumProductOfThreeNumbers {


    public static void main(String[] args) {
        No628MaximumProductOfThreeNumbers t = new No628MaximumProductOfThreeNumbers();
        List<int[]> numList = new ArrayList<>();
        numList.add(new int[]{1, 2, 3});
        numList.add(new int[]{1, 2, 3, 4});
        numList.add(new int[]{-1, -2, -3});
        int res;
        for (int[] nums : numList) {
            res = t.maximumProduct(nums);
            System.out.println("max:" + res);
        }
    }

    /**
     * 方法2
     *
     * @param nums -1000< n < 1000
     * @return
     */
    public int maximumProduct(int[] nums) {
        // max1 > max2 > max3 > min2 > min1
        int max1 = -1001, max2 = -1001, max3 = -1001, min1 = 1001, min2 = 1001;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    /**
     * 遍历一次，找到最大的三个和最小的两个
     *
     * @param nums
     * @return
     */
    public int maximum20220627(int[] nums) {
        int max1 = -1001, max2 = -1001, max3 = -1001;
        int min1 = 1001, min2 = 1001;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min2 * min1);
    }
}
