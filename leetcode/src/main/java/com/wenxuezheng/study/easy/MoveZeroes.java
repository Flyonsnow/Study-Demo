package com.wenxuezheng.study.easy;

/**
 * @author hu.bo@cestc.cn
 * @date 2021/12/27 11:52 PM
 */
public class MoveZeroes {


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    public static void moveZeroes(int[] nums) {
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
}
