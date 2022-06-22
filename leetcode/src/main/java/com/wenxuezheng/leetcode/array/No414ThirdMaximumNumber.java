package com.wenxuezheng.leetcode.array;


public class No414ThirdMaximumNumber {

    public static void main(String[] args) {
        No414ThirdMaximumNumber t = new No414ThirdMaximumNumber();
        int[] nums = {2,2,3,1};
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
            }else if (num == first) {
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
            }else if (num == second) {
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
            }else if (num == third) {
                continue;
            }
            if (num >= third) {
                third = num;
            }
        }
        return third == null ? first : third;
    }

}
