package com.haoliang.algorithm.sort;

public class Sort06_HeapSort {
    public static void main(String[] args) {
        int[] sortArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(sortArray);
        heapSort(sortArray);
        printArray(sortArray);
    }

    private static void heapSort(int[] sortArray) {
        if (sortArray == null || sortArray.length < 2) {
            return;
        }
        for (int index = 0; index < sortArray.length; index++) {
            heapInsert(sortArray, index);
        }
        int heapSize = sortArray.length;
        swap(sortArray, 0, --heapSize);
        while (heapSize > 0) {
            heapify(sortArray, 0, heapSize);
            swap(sortArray, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] sortArray, int index) {
        while (sortArray[index] > sortArray[(index - 1) / 2]) {
            swap(sortArray, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] sortArray, int parent, int heapSize) {
        int left = parent * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && sortArray[left + 1] > sortArray[left] ? left + 1 : left;
            largest = sortArray[largest] > sortArray[parent] ? largest : parent;
            if (parent == largest) {
                break;
            }
            swap(sortArray, parent, largest);
            parent = largest;
            left = parent * 2 + 1;
        }
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
