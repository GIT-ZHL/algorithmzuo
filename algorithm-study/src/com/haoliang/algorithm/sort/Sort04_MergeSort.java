package com.haoliang.algorithm.sort;

public class Sort04_MergeSort {
    public static void main(String[] args) {
        int[] sortArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(sortArray);
        mergeSort(sortArray);
        printArray(sortArray);
    }

    private static void mergeSort(int[] sortArray) {
        if (sortArray == null || sortArray.length < 2) {
            return;
        }
        mergeSort(sortArray, 0, sortArray.length - 1);
    }

    private static void mergeSort(int[] sortArray, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(sortArray, left, mid);
        mergeSort(sortArray, mid + 1, right);
        realMergeSort(sortArray, left, mid, right);
    }

    private static void realMergeSort(int[] sortArray, int left, int mid, int right) {
        int[] tempArray = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            tempArray[i++] = sortArray[p1] < sortArray[p2] ? sortArray[p1++] : sortArray[p2++];
        }
        while (p1 <= mid) {
            tempArray[i++] = sortArray[p1++];
        }
        while (p2 <= right) {
            tempArray[i++] = sortArray[p2++];
        }
        for (i = 0; i < tempArray.length; i++) {
            sortArray[left + i] = tempArray[i];
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
