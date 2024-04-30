package org.example.leetcode.solutions;

import java.util.Arrays;

class Solution455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int cnt = 0;

        int i = g.length - 1;
        int j = s.length - 1;

        while (i >= 0 && j >= 0) {
            if (g[i] <= s[j]) {
                cnt++;
                j--;
            }
            i--;
        }
        return cnt;
    }

}
