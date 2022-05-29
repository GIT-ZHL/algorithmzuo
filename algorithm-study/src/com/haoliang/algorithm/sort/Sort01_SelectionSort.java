package com.haoliang.algorithm.sort;

/**
 * 选择排序
 *
 * @author zhaohaoliang
 */
public class Sort01_SelectionSort {
    public static void main(String[] args) {
        int[] sortArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(sortArray);
        selectionSort(sortArray);
        printArray(sortArray);
    }

    private static void selectionSort(int[] sortArray) {
        if (sortArray == null || sortArray.length < 2) {
            return;
        }
        for (int i = 0; i < sortArray.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortArray.length; j++) {
                minIndex = sortArray[minIndex] > sortArray[j] ? j : minIndex;
            }
            swap(sortArray, minIndex, i);
        }
    }

    private static void swap(int[] sortArray, int minIndex, int i) {
        int temp = sortArray[minIndex];
        sortArray[minIndex] = sortArray[i];
        sortArray[i] = temp;
    }

    private static void printArray(int[] sortArray) {
        System.out.print("打印数组:");
        for (int i : sortArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
