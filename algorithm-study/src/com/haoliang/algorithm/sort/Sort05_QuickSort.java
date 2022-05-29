package com.haoliang.algorithm.sort;

public class Sort05_QuickSort {
    public static void main(String[] args) {
        int[] sortArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(sortArray);
        quickSort(sortArray);
        printArray(sortArray);
    }

    private static void quickSort(int[] sortArray) {
        if (sortArray == null || sortArray.length < 2) {
            return;
        }
        quickSort(sortArray, 0, sortArray.length - 1);
    }

    private static void quickSort(int[] sortArray, int left, int right) {
        if (left < right) {
            swap(sortArray, left + (int) (Math.random() * (right - left + 1)), right);
            int[] pIndexArray = partition(sortArray, left, right);
            quickSort(sortArray, left, pIndexArray[0]);
            quickSort(sortArray, pIndexArray[1] + 1, right);
        }
    }

    private static int[] partition(int[] sortArray, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (sortArray[left] < sortArray[right]) {
                swap(sortArray, ++less, left++);
            } else if (sortArray[left] > sortArray[right]) {
                swap(sortArray, --more, left);
            } else {
                left++;
            }
        }
        swap(sortArray, more, right);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] sortArray, int i, int j) {
        int temp = sortArray[i];
        sortArray[i] = sortArray[j];
        sortArray[j] = temp;
    }


    private static void printArray(int[] sortArray) {
        System.out.print("数组:");
        for (int i = 0; i < sortArray.length; i++) {
            System.out.print(sortArray[i] + " ");
        }
        System.out.println();
    }
}
