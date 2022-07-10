package com.wenxuezheng.study.algorithm;

/**
 * @author hubo
 */
public class Mergesort {


    public static void main(String[] args) {
        //int[] arr = {6, 202, 100, 301, 38, 8, 1, 301};
        int[] arr = {5,2,3,1};
        //int[] arr = {2, 1, 5, 6, 3, 7, 4};
        int[] tmp = new int[arr.length];

        //mergesortWithRecursive(arr, tmp, 0, arr.length - 1);
        //mergesortWithRecursive2(arr, tmp, 0, arr.length - 1);
        //mergesortWithLoop(arr);
        mergesortWithLoop2(arr);

        for (int i : arr) {
            System.out.print(i + ",");

        }
    }

    public static void mergesortWithRecursive(int[] arr, int[] tmp, int start, int end) {
        if (start == end) {
            return;
        }
        // 分解
        int len = end - start;
        int mid = len / 2 + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergesortWithRecursive(arr, tmp, start1, end1);
        mergesortWithRecursive(arr, tmp, start2, end2);
        // merge
        int i = start;

        while (start1 <= end1 && start2 <= end2) {
            tmp[i++] = arr[start1] <= arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            tmp[i++] = arr[start1++];
        }
        while (start2 <= end2) {
            tmp[i++] = arr[start2++];
        }
        for (int j = start; j <= end; j++) {
            arr[j] = tmp[j];
        }
        return;
    }


    public static void mergesortWithRecursive2(int[] arr, int[] tmp, int start, int end) {
        // 递归结束条件
        if (start == end) {
            return;
        }
        // 分解
        int len = end - start;
        int mid = len / 2 + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergesortWithRecursive2(arr, tmp, start1, end1);
        mergesortWithRecursive2(arr, tmp, start2, end2);
        // 合并 while
        //int k = start;
        //while (start1 <= end1 && start2 <= end2) {
        //    tmp[k++] = arr[start1] <= arr[start2] ? arr[start1++] : arr[start2++];
        //}
        //while (start1 <= end1) {
        //    tmp[k++] = arr[start1++];
        //}
        //while (start2 <= end2) {
        //    tmp[k++] = arr[start2++];
        //}
        //for (int i = start; i <= end; i++) {
        //    arr[i] = tmp[i];
        //}

        // 合并 for
        merge(arr, tmp, start1, mid, end2);
        //for (int i = start1; i <= end2; i++) {
        //    if (start1 > mid) {
        //        tmp[i] = arr[start2++];
        //    } else if (start2 > end2) {
        //        tmp[i] = arr[start1++];
        //    } else if (arr[start2] < arr[start1]) {
        //        tmp[i] = arr[start2++];
        //    } else {
        //        tmp[i] = arr[start1++];
        //    }
        //}
        //for (int i = start; i <= end; i++) {
        //    arr[i] = tmp[i];
        //}
    }

    public static void mergesortWithLoop(int[] arr) {
        int[] orderedArr = new int[arr.length];
        // 确定每次处理的块，第一次loop把每两个数字归为一组进行比较，第二次loop把每4个数字归为一组
        for (int i = 2; i < arr.length * 2; i *= 2) {

            for (int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = left + i / 2 >= arr.length ? (arr.length - 1) : (left + i / 2);
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid) {
                    orderedArr[start++] = arr[l++];
                }

                while (m <= right) {
                    orderedArr[start++] = arr[m++];
                }
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
    }

    public static void mergesortWithLoop2(int[] arr) {
        int[] tmp = new int[arr.length];
        // 确定每次处理的块，第一次loop把每两个数字归为一组进行比较，第二次loop把每4个数字归为一组
        for (int sz = 1; sz < arr.length; sz *= 2) {
            for (int j = 0; j < (arr.length ); j += sz * 2) {
                int start = j, mid = j + sz - 1, end = Math.min(j + sz + sz - 1, arr.length - 1);
                merge(arr, tmp, start, mid, end);
            }
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int start1 = start, start2 = mid + 1;
        for (int i = start; i <= end; i++) {
            // 左侧全部取完
            if (start1 > mid) {
                arr[i] = tmp[start2++];
            } else if (start2 > end) {
                arr[i] = tmp[start1++];
            } else if (tmp[start1] <= tmp[start2]) {
                arr[i] = tmp[start1++];
            } else {
                arr[i] = tmp[start2++];
            }
        }
    }

}
