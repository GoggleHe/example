package org.example.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 用连续自然数之和来表达整数
 */
public class Main28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getResult(sc.nextInt())

        ;
    }

    public static void getResult(int t) {
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) arr[i] = i + 1;

        ArrayList<int[]> ans = new ArrayList<>();

        int l = 0;
        int r = 1;

        int sum = arr[l];
        while (l < t) {
            if (sum > t) {
                sum -= arr[l++];
            } else if (sum == t) {
                ans.add(Arrays.copyOfRange(arr, l, r));
                sum -= arr[l++];
                if (r >= t) break;
                sum += arr[r++];
            } else {
                sum += arr[r++];
            }
        }

        ans.sort((a, b) -> a.length - b.length);

        for (int[] an : ans) {
            StringJoiner sj = new StringJoiner("+");
            for (int v : an) sj.add(v + "");
            System.out.println(t + "=" + sj);
        }

        System.out.println("Result:" + ans.size());
    }

}
