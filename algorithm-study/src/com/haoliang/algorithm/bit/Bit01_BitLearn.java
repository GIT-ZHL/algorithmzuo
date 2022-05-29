package com.haoliang.algorithm.bit;

public class Bit01_BitLearn {
    public static void main(String[] args) {
        int num = 156;
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
