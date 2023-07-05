package com.wenxuezheng.leetcode;

/**
 * @author    
 * 2022/10/18 19:02
 */

public class No66PlusOne {
    public static void main(String[] args) {
        int[] digits = {9};

        int[] ints = new No66PlusOne().plusOne(digits);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        int[] ints = null;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 10) {
                break;
            } else {
                if (i != 0) {
                    digits[i - 1] = digits[i - 1] + 1;
                    digits[i] = 0;
                } else {
                    digits[i] = 0;
                    ints = new int[digits.length + 1];
                    ints[0] = 1;
                    System.arraycopy(digits, 0, ints, 1, digits.length);
                }
            }
        }
        return ints == null ? digits : ints;
    }

    public void plus(int[] digits, int pos) {
        int i = digits[pos] + 1;
        if (i == 10) {

        } else {

        }


    }
}
