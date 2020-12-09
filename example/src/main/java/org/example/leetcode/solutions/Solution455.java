package org.example.leetcode.solutions;

import java.util.Arrays;

/**
 *
 **/
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1, j = s.length - 1, res = 0;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                res++;
                j--;
            }
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};

        Solution455 solution455 = new Solution455();
        int contentChildren = solution455.findContentChildren(g, s);
        System.out.println(contentChildren);
    }
}
