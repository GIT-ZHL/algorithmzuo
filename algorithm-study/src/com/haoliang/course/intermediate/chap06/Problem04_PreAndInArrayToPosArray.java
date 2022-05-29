package com.haoliang.course.intermediate.chap06;

import java.util.HashMap;

public class Problem04_PreAndInArrayToPosArray {

    public static int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
        return pos;
    }

    public static int setPos(int[] p, int pi, int pj, int[] n, int ni, int nj, int[] s, int si,
                             HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return si;
        }
        s[si--] = p[pi];
        int i = map.get(p[pi]);
        si = setPos(p, pj - nj + i + 1, pj, n, i + 1, nj, s, si, map);
        return setPos(p, pi + 1, pi + i - ni, n, ni, i - 1, s, si, map);
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        int[] pos = getPosArray(pre, in);
        printArray(pos);

        String[] preStr = {"A", "C", "D", "E", "F", "H", "G", "B"};
        String[] inStr = {"D", "E", "C", "A", "H", "F", "B", "G"};
        String[] posStr = getPosStringArray(preStr, inStr);
        printStr(posStr);
    }

    private static void printStr(String[] posStr) {
        if (posStr == null) {
            return;
        }
        for (int i = 0; i != posStr.length; i++) {
            System.out.print(posStr[i] + " ");
        }
        System.out.println();
    }

    private static String[] getPosStringArray(String[] preStr, String[] inStr) {
        if (preStr == null || inStr == null) {
            return null;
        }
        int len = preStr.length;
        String[] posStr = new String[len];
        HashMap<String, Integer> inMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inMap.put(inStr[i], i);
        }
        setPosStr(preStr, 0, len - 1, inMap, 0, len - 1, posStr, len - 1);
        return posStr;
    }

    private static int setPosStr(String[] preStr, int preI, int preJ, HashMap<String, Integer> inMap, int inI, int inJ, String[] posStr, int si) {
    	if (preI > preJ) {
            return si;
        }
		System.out.println("Si:"+si+",PreI:"+preI);
        posStr[si--] = preStr[preI];
        int i = inMap.get(preStr[preI]);
        si = setPosStr(preStr, preJ - inJ + i + 1, preJ, inMap, i + 1, inJ, posStr, si);
        return setPosStr(preStr, preI + 1, preI + i - inI, inMap, inI, i - 1, posStr, si);
    }
}
