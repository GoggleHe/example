package org.example.leetcode.solutions;

/**
 *
 **/
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        Solution392 solution392 = new Solution392();
        String s = "axc", t = "ahbgdc";
        boolean subsequence = solution392.isSubsequence(s, t);
        System.out.println(subsequence);
    }
}
