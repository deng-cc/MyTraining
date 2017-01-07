package com.code.sort;

/**
 * 选择排序的基本思想是每一趟（假设是第i趟）处理都是从n-i+1个数据中选择一个数据最小（或最大）的作为有序序列中的第i个数据。
 * 其中最简单的一种称为直接选择排序。
 */
public class SelectionSort {

    /**
     * 直接选择排序法（升序，从小到大）
     * @param arr
     * @return
     */
    public static int[] selectionSortMinToMax(int[] arr) {
        int min;
        for (int j = 0; j < arr.length - 1; j++) {
            min = j;
            //标记最小值的位置
            for (int i = j; i < arr.length; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }
            //交换最小值到arr[j]
            int temp = arr[j];
            arr[j] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }


    /**
     * 直接选择排序法（降序，从大到小）
     * @param arr
     * @return
     */
    public static int[] selectionSortMaxToMin(int[] arr) {
        int min;
        for (int j = 0; j < arr.length - 1; j++) {
            min = j;
            for (int i = j; i < arr.length; i++) {
                if (arr[i] > arr[min]) {
                    min = i;
                }
            }
            int temp = arr[j];
            arr[j] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }


    /**
     * test
     */
    public static void main(String[] args) {
        int[] test = new int[]{51, 38, 49, 27, 62, 5, 16};
        test = SelectionSort.selectionSortMinToMax(test);
        for (int temp : test) {
            System.out.print(temp + ", ");
        }

        System.out.println();

        test = SelectionSort.selectionSortMaxToMin(test);
        for (int temp : test) {
            System.out.print(temp + ", ");
        }

    }
}
