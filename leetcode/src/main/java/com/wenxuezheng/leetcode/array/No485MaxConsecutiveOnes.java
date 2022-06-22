package com.wenxuezheng.leetcode.array;


/**
 * 485 Max Consecutive Ones
 */
public class No485MaxConsecutiveOnes {

    public static void main(String[] args) {
        No485MaxConsecutiveOnes no485MaxConsecutiveOnes = new No485MaxConsecutiveOnes();

        int[] nums = {1, 1, 0, 1, 1, 1};
        int res = no485MaxConsecutiveOnes.maxConsecutive(nums);

        System.out.println("max : " + res);

    }

    /**
     * Time: O(n) Space:O(1)
     * @param nums
     * @return
     */
    private int maxConsecutive(int[] nums) {
        int max = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = max >= count ? max : count;
                count = 0;
            }
        }
        return max >= count ? max : count;
    }
}
