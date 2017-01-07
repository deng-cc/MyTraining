package com.code.sort;

/**
 * 冒泡排序是交换排序中一种简单的排序方法。
 * 它的基本处理思想是通过对相邻两个数据的比较及其交换来达到排序的目的。
 */
public class BubbleSort {

    /**
     * 冒泡排序法（升序，从小到大）
     * @param arr
     * @return
     */
    public static int[] bubbleSortMinToMax(int[] arr) {
        int len = arr.length - 1;
        while (len >= 1) {
            for (int i = 0; i < len; i++) {
                int temp;
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            len--;
        }
        return arr;
    }

    /**
     * 冒泡排序法（降序，从大到小）
     * @param arr
     * @return
     */
    public static int[] bubbleSortMaxToMin(int[] arr) {
        int len = arr.length - 1;
        while (len >= 1) {
            for (int i = 0; i < len; i++) {
                int temp;
                if (arr[i] < arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            len--;
        }
        return arr;
    }

    /**
     * test
     */
    public static void main(String[] args) {
        int[] test = new int[]{51, 38, 49, 27, 62, 5, 16};
        test = BubbleSort.bubbleSortMinToMax(test);
        for (int temp : test) {
            System.out.print(temp + ", ");
        }

        System.out.println();

        test = BubbleSort.bubbleSortMaxToMin(test);
        for (int temp : test) {
            System.out.print(temp + ", ");
        }
    }
}
