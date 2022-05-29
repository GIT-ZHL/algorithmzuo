package com.haoliang.course.promote.chap07;

public class Code06_UnRepeatCoinsMin {
    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int index, int aim) {
        if (aim < 0) {
            return -1;
        }
        if (aim == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }
        int p1 = process1(arr, index + 1, aim);
        int p2 = process1(arr, index + 1, aim - arr[index]);
        if (p1 == -1 && p2 == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2 + 1;
            }
            if (p2 == -1) {
                return p1;
            }
            return Math.min(p1, p2 + 1);
        }
    }


    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -2;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    private static int process2(int[] arr, int index, int aim, int[][] dp) {
        if (aim < 0) {
            return -1;
        }
        if (dp[index][aim] != -2) {
            return dp[index][aim];
        }
        if (aim == 0) {
            dp[index][aim] = 0;
        } else if (index == arr.length) {
            dp[index][aim] = -1;
        } else {
            int p1 = process2(arr, index + 1, aim, dp);
            int p2 = process2(arr, index + 1, aim - arr[index], dp);
            if (p1 == -1 && p2 == -1) {
                dp[index][aim] = -1;
            } else {
                if (p1 == -1) {
                    dp[index][aim] = p2 + 1;
                } else if (p2 == -1) {
                    dp[index][aim] = p1;
                } else {
                    dp[index][aim] = Math.min(p1, p2 + 1);
                }
            }
        }
        return dp[index][aim];
    }

    public static int minCoins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int row = 0; row <= N; row++) {
            dp[row][0] = 0;
        }
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 1; rest <= aim; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = -1;
                if (rest - arr[index] >= 0) {
                    p2 = dp[index + 1][rest - arr[index]];
                }
                if (p1 == -1 && p2 == -1) {
                    dp[index][rest] = -1;
                } else {
                    if (p1 == -1) {
                        dp[index][rest] = p2 + 1;
                    } else if (p2 == -1) {
                        dp[index][rest] = p1;
                    } else {
                        dp[index][rest] = Math.min(p1, p2 + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 3, 5, 3};
        int aim = 11;
        System.out.println(minCoins1(arr, aim));
        System.out.println(minCoins2(arr, aim));
        System.out.println(minCoins3(arr, aim));
    }
}
