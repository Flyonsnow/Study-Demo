package com.wenxuezheng.leetcode.array.traverse;


public class No495TeemoAttacking {


    public static void main(String[] args) {
        No495TeemoAttacking t = new No495TeemoAttacking();
        int[] timeSeries = {1, 4};
        int duration = 2;
        int res;
        //res = t.findPoisonedDuration20220622(timeSeries, duration);
        res = t.findPoisonedDurationAnother20220622(timeSeries, duration);
        System.out.println("res :" + res);
        int[] timeSeries2 = {1, 2};
        duration = 2;
        //res = t.findPoisonedDuration20220622(timeSeries2, duration);
        res = t.findPoisonedDurationAnother20220622(timeSeries2, duration);
        System.out.println("res :" + res);


    }

    public int findPoisonedDuration20220622(int[] timeSeries, int duration) {
        int res = 0, last = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            // 上一次共计中毒结束的时间
            last = timeSeries[i - 1] + duration - 1;
            res += last < timeSeries[i] ? duration : timeSeries[i] - timeSeries[i - 1];
        }
        return res + duration;
    }

    public int findPoisonedDurationAnother20220622(int[] timeSeries, int duration) {
        // last 必须<0，否则在0时计算不对
        int res = 0, last = -1;
        for (int i = 0; i < timeSeries.length; i++) {
            int currExp = timeSeries[i] + duration - 1;
            res += last < timeSeries[i] ? duration : currExp - last;
            last = currExp;
        }
        return res;
    }

    public int findPoisonedDuration20220627(int[] timeSeries, int duration) {
        int total = 0, last = timeSeries[0] + duration - 1;
        for (int i = 1; i < timeSeries.length; i++) {
            int current = timeSeries[i] + duration - 1;
            total += last >= timeSeries[i] ? current - last : duration;
            last = current;
        }

        return total + duration;
    }
}
