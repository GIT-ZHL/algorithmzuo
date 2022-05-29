package com.haoliang.algorithm.sort;

public class Sort07_CountSort {
    public static void main(String[] args) {
        int[] sortArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(sortArray);
        countSort(sortArray);
        printArray(sortArray);
    }

    private static void countSort(int[] sortArray) {
        if (sortArray == null || sortArray.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sortArray.length; i++) {
            max = Math.max(max, sortArray[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < sortArray.length; i++) {
            bucket[sortArray[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                sortArray[i++] = j;
            }
        }
    }


    private static void printArray(int[] sortArray) {
        System.out.print("数组:");
        for (int i = 0; i < sortArray.length; i++) {
            System.out.print(sortArray[i] + " ");
        }
        System.out.println();
    }
}
