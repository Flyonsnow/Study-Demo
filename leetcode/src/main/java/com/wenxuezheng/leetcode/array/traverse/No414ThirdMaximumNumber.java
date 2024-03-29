package com.wenxuezheng.leetcode.array.traverse;


public class No414ThirdMaximumNumber {

    public static void main(String[] args) {
        No414ThirdMaximumNumber t = new No414ThirdMaximumNumber();
        int[] nums = {2, 2, 3, 1};
        int res;
        res = t.thirdMax(nums);
        System.out.println("third:" + res);
    }

    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;
        for (int num : nums) {

            if (first == null) {
                first = num;
                continue;
            } else if (num == first) {
                continue;
            }
            if (num >= first) {
                third = second;
                second = first;
                first = num;
                continue;
            }
            if (second == null) {
                second = num;
                continue;
            } else if (num == second) {
                continue;
            }
            if (num >= second) {
                third = second;
                second = num;
                continue;
            }
            if (third == null) {
                third = num;
                continue;
            } else if (num == third) {
                continue;
            }
            if (num >= third) {
                third = num;
            }
        }
        return third == null ? first : third;
    }

    /**
     * Time: O(n) Space: O(1)
     *
     * @param nums
     * @return
     */
    public int thirdMax20220727(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num == first || num == second || num == third) {
                continue;
            }
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }


}
