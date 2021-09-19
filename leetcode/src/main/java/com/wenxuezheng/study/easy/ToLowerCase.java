package com.wenxuezheng.study.easy;

/**
 * ToLowerCase
 *
 * @author hubo
 * @since 2019-03-21
 */
public class ToLowerCase {
    public static void main(String[] args) {
        String str = "Hello$";
        String s = method1(str);
        System.out.println(s);
    }

    public static String method1(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((byte) chars[i] < 91 && (byte) chars[i] > 64) {
                chars[i] = (char) ((byte) chars[i] + 32);
            }
        }
        return String.valueOf(chars);
    }
}
