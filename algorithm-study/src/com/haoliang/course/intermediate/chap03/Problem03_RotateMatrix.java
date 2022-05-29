package com.haoliang.course.intermediate.chap03;

public class Problem03_RotateMatrix {

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);


        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        System.out.println(a + ":" + b);


        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + ":" + b);

        a = 1;
        b = 2;
        c = 3;
        System.out.println(a + ":" + b + ":" + c);

        temp = a;
        a = c;
        c = b;
        b = temp;
        System.out.println(a + ":" + b + ":" + c);

        a = 1;
        b = 2;
        c = 3;
        d = 4;

        temp = a;
        a = d;
        d = c;
        c = b;
        b = temp;
        System.out.println(a + ":" + b + ":" + c + ":" + d);
    }

}
