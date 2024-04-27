package org.example;

import java.util.Scanner;

public class Gem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] gems = new int[n];
        for (int i = 0; i < n; i++) {
            gems[i] = sc.nextInt();
        }
        int v = sc.nextInt();

        System.out.println(getResult(n, gems, v));
    }

    private static int getResult(int n, int[] gems, int v) {
        int l = 0;
        int r = 0;

        int ans = 0;

        int window_sum = 0;


        outer:
        while (r < n) {
            window_sum += gems[r];
            if (window_sum <= v) {
                r++;// r右移
            } else {
                ans = Math.max(ans, r - l);
                // l右移
                while (l < r) {
                    window_sum -= gems[l++];
                    if (window_sum <= v) {
                        r++;
                        continue outer;
                    }
                }
                l = ++r;
                window_sum = 0;
            }
        }
        if (window_sum <= v) {
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
