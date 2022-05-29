package com.haoliang.algorithm.sort;

/**
 * 冒泡排序
 *
 * @author zhaohaoliang
 */
public class Sort02_BubbleSort {
    public static void main(String[] args) {
        int[] sortArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(sortArray);
        bubbleSort(sortArray);
        printArray(sortArray);
    }

    private static void bubbleSort(int[] sortArray) {
        if (sortArray == null || sortArray.length < 2) {
            return;
        }
        for (int j = sortArray.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (sortArray[i] > sortArray[i + 1]) {
                    swap(sortArray, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] sortArray, int i, int j) {
        int temp = sortArray[i];
        sortArray[i] = sortArray[j];
        sortArray[j] = temp;
    }

    private static void printArray(int[] sortArray) {
        System.out.print("打印数组:");
        for (int i : sortArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
