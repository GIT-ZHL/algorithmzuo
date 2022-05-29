package com.haoliang.algorithm.sort;

public class Sort08_RadixSort {
    public static void main(String[] args) {
        int[] sortArray = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        printArray(sortArray);
        radixSort(sortArray);
        printArray(sortArray);
    }

    private static void radixSort(int[] sortArray) {
        if (sortArray == null || sortArray.length < 2) {
            return;
        }
        radixSort(sortArray, 0, sortArray.length - 1, maxBit(sortArray));
    }

    private static int maxBit(int[] sortArray) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sortArray.length; i++) {
            max = Math.max(max, sortArray[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max = max / 10;
        }
        return res;
    }

    private static void radixSort(int[] sortArray, int start, int end, int maxBit) {
        final int bucketLen = 10;
        int[] tempArray = new int[end - start + 1];
        int i = 0, j = 0;
        for (int d = 1; d <= maxBit; d++) {
            int[] bucket = new int[bucketLen];
            for (i = start; i <= end; i++) {
                j = getDigit(sortArray[i], d);
                bucket[j]++;
            }
            for (j = 1; j < bucketLen; j++) {
                bucket[j] = bucket[j] + bucket[j - 1];
            }
            for (i = end; i >= start; i--) {
                j = getDigit(sortArray[i], d);
                tempArray[bucket[j] - 1] = sortArray[i];
                bucket[j]--;
            }
            for (i = start, j = 0; i <= end; i++, j++) {
                sortArray[i] = tempArray[j];
            }
        }
    }

    private static int getDigit(int i, int d) {
        return (i / (int) Math.pow(10, d - 1)) % 10;
    }


    private static void printArray(int[] sortArray) {
        System.out.print("数组:");
        for (int i = 0; i < sortArray.length; i++) {
            System.out.print(sortArray[i] + " ");
        }
        System.out.println();
    }
}
