package com.haoliang.algorithm.sort;

/**
 * 插入排序
 *
 * @author zhaohaoliang
 */
public class Sort03_InsertionSort {
    public static void main(String[] args) {
        int[] sortArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(sortArray);
        insertionSort(sortArray);
        printArray(sortArray);
    }

    private static void insertionSort(int[] sortArray) {
        if (sortArray == null || sortArray.length < 2) {
            return;
        }
        for (int i = 1; i < sortArray.length; i++) {
            for (int j = i - 1; j >= 0 && sortArray[j] > sortArray[j + 1]; j--) {
                swap(sortArray, j, j + 1);
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
