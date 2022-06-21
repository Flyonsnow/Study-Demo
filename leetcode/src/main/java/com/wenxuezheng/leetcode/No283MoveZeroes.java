package com.wenxuezheng.leetcode;

/**
 * #283
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.
 *
 * **Note** that you must do this in-place without making a copy of the array.
 */
public class No283MoveZeroes {

    private static int[] nums = {0, 1, 0, 3, 12};

    public static void main(String[] args) {
        moveZeros20220520(nums);
        moveZeros20220521(nums);
        //test1(nums);
        moveZeros20220616(nums);
        moveZeros20220617(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    /**
     * 2022-05-20 first
     *
     * @param nums
     */
    public static void moveZeros20220520(int[] nums) {
        Integer zeroPosition = null;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zeroPosition != null) {
                    nums[zeroPosition] = nums[i];
                    nums[i] = 0;
                    zeroPosition += 1;
                }
            } else {
                zeroPosition = zeroPosition == null ? i : zeroPosition;
            }
        }
    }

    /**
     * 高票-滚雪球
     * https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation
     */
    public static void 滚雪球(int[] nums) {
        int snow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snow++;
            } else if (snow > 0) {
                nums[i - snow] = nums[i];
                nums[i] = 0;
            }
        }
    }

    /**
     * 高票-insertIndex
     * https://leetcode.com/problems/move-zeroes/discuss/72011/Simple-O(N)-Java-Solution-Using-Insert-Index
     */
    public static void insertIndex(int[] nums) {
        int nonZeroNum = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[nonZeroNum] = num;
                nonZeroNum++;
            }
        }
        for (int i = nonZeroNum; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void moveZeros20220521(int[] nums) {
        int pos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }

    public static void moveZeros20220616(int[] nums) {
        int pos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[pos] = num;
                pos++;
            }
        }
        for (int i = pos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeros20220617(int[] nums) {
        int pos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }
        for (int i = pos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
