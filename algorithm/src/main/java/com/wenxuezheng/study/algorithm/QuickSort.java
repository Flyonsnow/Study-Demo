package com.wenxuezheng.study.algorithm;


public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {6, 202, 100, 301, 38, 8, 1, 301};
        //int[] arr = {5, 2, 3, 1};
        //int[] arr = {2, 1, 5, 6, 3, 7, 4};
        int[] tmp = new int[arr.length];

        //mergesortWithRecursive(arr, tmp, 0, arr.length - 1);
        //mergesortWithRecursive2(arr, tmp, 0, arr.length - 1);
        //mergesortWithLoop(arr);
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + ",");

        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }

        int j = partition(arr, start, end);
        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        //创建指针
        int left = start, right = end + 1;
        int v = arr[start];

        while (true) {
            while (arr[++left] < v) {
                if (left == end) {
                    break;
                }
            }
            while (v < arr[--right] ) {
                if (start == right) {
                    break;
                }
            }
            if (left >= right) {
                break;
            }

            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
        arr[start] = arr[right];
        arr[right] = v;
        return right;
    }

}
