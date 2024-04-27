package org.example.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串变换最小字符串
 */
public class Main18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    public static String getResult(String s) {
        char[] minSArr = s.toCharArray();
        Arrays.sort(minSArr);

        String minS = new String(minSArr);
        if (minS.equals(s)) return s;

        char[] sArr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (sArr[i] != minSArr[i]) {
                char tmp = sArr[i];
                sArr[i] = minSArr[i];

                int swapIndex = s.lastIndexOf(minSArr[i]);
                sArr[swapIndex] = tmp;
                break;
            }
        }

        return new String(sArr);
    }
}
